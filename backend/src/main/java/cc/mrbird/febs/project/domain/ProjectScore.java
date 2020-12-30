package cc.mrbird.febs.project.domain;

import java.io.Serializable;
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
public class ProjectScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sid;

    private Integer totalScore;

    private Integer processScore;

    private Integer docsScore;

    private Integer completeScore;

    private Integer presentationScore;

    private String feedback;


}
