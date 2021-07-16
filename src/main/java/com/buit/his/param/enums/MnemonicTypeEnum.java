package com.buit.his.param.enums;

import java.util.function.Function;

import com.buit.utill.PinyinUtils;
import com.buit.utill.WubiUtils;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/20 16:26
 */
public enum MnemonicTypeEnum {
    py((v)-> PinyinUtils.getSimplePinYin(v)),
    wb((v)-> WubiUtils.getSimpleWuBi(v)),
    ;

    Function<String,String> generate;

    MnemonicTypeEnum(Function<String, String> generate) {
        this.generate = generate;
    }

    public Function<String, String> getGenerate() {
        return generate;
    }
}
