package cc.mrbird.febs.project.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 
 *
 * @author hyl
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sid;

    private String name;

    private String classs;


}
