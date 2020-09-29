package com.lhwl.wzk.mybatis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mrli
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private Integer grade;

    private List<Map<String, Object>> last = new ArrayList<>();


}
