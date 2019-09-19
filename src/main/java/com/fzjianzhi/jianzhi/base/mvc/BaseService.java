package com.fzjianzhi.jianzhi.base.mvc;

import com.fzjianzhi.jianzhi.base.utils.CopyUtil;
import com.github.wenhao.jpa.Specifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * BaseService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/9
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@Slf4j
public class BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected BaseDao<T, ID> baseDao;


    public void delete(ID id) {
        baseDao.deleteById(id);
    }

    public void setDeletedTrue(ID id) {
        baseDao.setDeletedTrue(id);
    }

    public Optional<T> findOne(ID id) {
        return baseDao.findById(id);
    }

    public List<T> findAll() {
        return baseDao.findAll();
    }

    public Page<T> findAll(Integer pageNumber, Integer pageSize) {
        Page<T> page;
        Specification<T> specification = Specifications.<T>and()
                .eq("isDeleted", false).build();
        if (pageSize > 0) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            page = findAll(specification, pageable);
        }
        else if (pageSize == 0) {
            page = new PageImpl<>(findAll());
        }
        else {
            page = new PageImpl<>(findAll(specification));
        }
        return page;
    }

    public List<T> findAll(Specification<T> specification) {
        return baseDao.findAll(specification);
    }

    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return baseDao.findAll(specification, pageable);
    }

    public Long count() {
        Specification<T> specification = Specifications.<T>and()
                .eq("isDeleted", false).build();
        return baseDao.count(specification);
    }

    @Transactional
    public void save(T entity) {
        if (entity.getId() != null) {
            T oldEntity = findOne(entity.getId()).orElse(null);
            if (oldEntity != null) {
                // update not null properties
                CopyUtil.copyNullProperties(oldEntity, entity);
                baseDao.save(entity);
                return;
            }
        }
        // create
        baseDao.save(entity);
    }
}
