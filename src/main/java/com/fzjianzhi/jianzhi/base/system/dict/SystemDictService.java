package com.fzjianzhi.jianzhi.base.system.dict;

import com.fzjianzhi.jianzhi.base.mvc.BaseService;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemDict;
import com.fzjianzhi.jianzhi.base.system.config.SystemDictItem;
import com.fzjianzhi.jianzhi.base.system.config.UseSystemDict;
import com.fzjianzhi.jianzhi.base.utils.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * SystemDictService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/18
 */
@Service
@Slf4j
public class SystemDictService extends BaseService<SystemDictEntity, Long> implements SystemConfig {

    @Value("${humor.dict.scan}")
    private String basePackageScan;

    private List<Class<?>> dataClasses;

    private List<SystemDict> systemDictList;

    private List<SystemDictEntity> systemDictEntityList;

    @Resource
    private SystemDictDao systemDictDao;


    @Cacheable(cacheNames = "cache", key = "#root.method.returnType + '_' + #name")
    public SystemDictEntity findByName(String name) {
        return systemDictDao.findByName(name);
    }

    public void createDict() {
        dataClasses = getDataClass();
        if (dataClasses.size() == 0) {
            log.warn("Use system dict class not found");
            return;
        }
        createSystemDictList();
        if (systemDictList.size() == 0) {
            log.warn("don't find systemDict");
            return;
        }
        createSystemDictEntityList();
        checkDeclare();
        saveSystemDictEntityList();
    }

    // 扫描获取所有Data
    private List<Class<?>> getDataClass() {
        return ClassUtil.getClassListByAnnotation(
                basePackageScan, UseSystemDict.class);
    }

    private void createSystemDictList() {
        systemDictList = new ArrayList<>();
        for (Class clazz : dataClasses) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SystemDict.class)) {
                    systemDictList.add(field.getAnnotation(SystemDict.class));
                }
            }
        }
    }

    private void createSystemDictEntityList() {
        systemDictEntityList = new ArrayList<>();
        for (SystemDict systemDict : systemDictList) {
            if (systemDict.items().length != 0) {
                SystemDictEntity systemDictEntity = new SystemDictEntity();
                systemDictEntity.setName(systemDict.name());
                if (systemDict.dictIcon().equals("")) {
                    systemDictEntity.setDictIcon(DEFAULT_DICT_ICON);
                } else {
                    systemDictEntity.setDictIcon(systemDict.dictIcon());
                }
                if (systemDict.comment().equals("")) {
                    systemDictEntity.setComment(systemDict.name());
                } else {
                    systemDictEntity.setComment(systemDict.comment());
                }
                List<SystemDictItemEntity> systemDictItemEntityList = new ArrayList<>();
                int index = 1;
                for (SystemDictItem systemDictItem : systemDict.items()) {
                    SystemDictItemEntity systemDictItemEntity = new SystemDictItemEntity();
                    systemDictItemEntity.setValueIndex(index ++);
                    systemDictItemEntity.setValue(systemDictItem.value());
                    if (systemDictItem.icon().equals("")) {
                        systemDictItemEntity.setIcon(DEFAULT_DICT_ITEM_ICON);
                    } else {
                        systemDictItemEntity.setIcon(systemDictItem.icon());
                    }
                    systemDictItemEntityList.add(systemDictItemEntity);
                }
                systemDictEntity.setItems(systemDictItemEntityList);
                systemDictEntityList.add(systemDictEntity);
            }
        }
    }

    private void checkDeclare() {
        // 判断是否有的字典未声明过
        for (SystemDict systemDict : systemDictList) {
            if (systemDict.items().length == 0) {
                boolean found = false;
                for (SystemDictEntity systemDictEntity : systemDictEntityList) {
                    if (systemDictEntity.getName().equals(systemDict.name())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    log.warn(systemDict.name() + " is not declare");
                }
            }
        }
    }

    private void saveSystemDictEntityList() {
        for (SystemDictEntity systemDictEntity : systemDictEntityList) {
            save(systemDictEntity);
        }
    }
}
