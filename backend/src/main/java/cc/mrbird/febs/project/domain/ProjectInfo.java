package cc.mrbird.febs.project.domain;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonFormat(timezone="GTM+8",pattern="yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(timezone="GTM+8",pattern="yyyy-MM-dd")
    private Date endTime;

    private String projectName;

    @JsonProperty(value = "managerName")
    private String groupLeader;

    private String projectType;

    private String projectDesc;

    private String teacherName;




}
