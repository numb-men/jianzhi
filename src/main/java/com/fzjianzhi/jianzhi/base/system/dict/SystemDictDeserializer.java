package com.fzjianzhi.jianzhi.base.system.dict;


import com.fzjianzhi.jianzhi.base.system.config.SystemDict;
import com.fzjianzhi.jianzhi.base.system.exception.common.SystemException;
import com.fzjianzhi.jianzhi.base.system.exception.enums.SystemResultEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * SystemDictDeserializer
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/19
 */
@Slf4j
@Component
public class SystemDictDeserializer extends JsonDeserializer<Integer> {

    @Resource
    private SystemDictService systemDictService;

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object o = jsonParser.getCurrentValue();
        String fieldName = jsonParser.getCurrentName();
        Class clazz = o.getClass();
        try {
            Field field = clazz.getDeclaredField(fieldName);
            if (field.isAnnotationPresent(SystemDict.class)) {
                SystemDict systemDict = field.getAnnotation(SystemDict.class);
                String dictName = systemDict.name();
                String text = jsonParser.getText();
                SystemDictEntity systemDictEntity = systemDictService.findByName(dictName);

                // NOTE !! 传 index 优先于 传 value
                try {
                    Integer integer = Integer.valueOf(text);
                    for (SystemDictItemEntity systemDictItemEntity : systemDictEntity.getItems()) {
                        if (systemDictItemEntity.getValueIndex().equals(integer)) {
                            return integer;
                        }
                    }
                }
                catch (NumberFormatException e) {
                    // 前端传的是value
                }
                for (SystemDictItemEntity systemDictItemEntity : systemDictEntity.getItems()) {
                    if (systemDictItemEntity.getValue().equals(text)) {
                        return systemDictItemEntity.getValueIndex();
                    }
                }
            }
            else {
                log.warn(fieldName + " not found @SystemDict annotation");
            }
        } catch (NoSuchFieldException e) {
            log.warn("not such field -- " + fieldName);
        }
        // 既不是index 也不是 value抛出异常
        throw new SystemException(SystemResultEnum.UN_MAPPING_DICT);
    }
}
