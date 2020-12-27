package cc.mrbird.febs.project.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author hyl
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProjectPeople implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String pid;

    private String sid;

    private String position;


}
