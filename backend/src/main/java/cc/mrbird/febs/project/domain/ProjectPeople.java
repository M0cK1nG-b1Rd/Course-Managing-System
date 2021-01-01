package cc.mrbird.febs.project.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@TableName("project_member_info")
public class ProjectPeople implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @TableId(type = IdType.AUTO)
    private long id;

    private String pid;

    private String sid;

    private String position;

    private TUserInfo tUserInfo;
}
