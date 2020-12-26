package cc.mrbird.febs.project.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 *
 * @author hyl
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProjectInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pid", type = IdType.AUTO)
    private Long  pid;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime endTime;

    private String projectName;

    private String groupName;

    private String groupLeader;


}
