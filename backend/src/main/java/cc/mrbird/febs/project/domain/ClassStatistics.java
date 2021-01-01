package cc.mrbird.febs.project.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClassStatistics {
    @TableField("avg_score")
    private float avgScore;
    @TableField("max_score")
    private float maxScore;
    @TableField("min_score")
    private float minScore;
}
