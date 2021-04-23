package com.xagu.mooc.user.vo;

import com.xagu.mooc.user.pojo.Power;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xagu
 * Created on 2020/6/10
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PowerOfRole extends Power {
    private String checkArr = "0";

    private static final long serialVersionUID = 1L;
}
