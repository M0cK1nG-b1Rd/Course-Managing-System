<template>
  <div id="components-layout-demo-basic">
    <a-layout>
      <a-layout-header>查看项目评分</a-layout-header>
      <a-layout-content>
<!--         第一行-->
        <a-row>
          <a-space :size="'small'">
            <!--           第一行第一列，展示自己的成绩-->
            <a-col :span="12">
              <!--              加权总分-->
              <a-row>
                <a-col :span="4">加权总分</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                    :percent="myScore.total"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              过程考核-->
              <a-row>
                <a-col :span="4">过程考核</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#fad900',
                  to: '#e5772c',}"
                    :percent="myScore.process"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              文档及报告-->
              <a-row>
                <a-col :span="4">文档及报告</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                    :percent="myScore.docs"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              完成情况-->
              <a-row>
                <a-col :span="4">完成情况</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#fad900',
                  to: '#e5772c',}"
                    :percent="myScore.completion"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
            </a-col>
            <a-col :span="2"><div>&nbsp</div></a-col>
            <!--              第一行第二列，展示评价及反馈-->
            <a-col :span="10">
              <a-row><div style="height: 20px"></div></a-row>
              <!--            老师评价-->
              <a-row>
                <Comment :commenter="'老师反馈'" :content="teacherFeedback"></Comment>
              </a-row>
              <!--            项目经理评价-->
              <a-row><div style="height: 20px"></div></a-row>
              <a-row>
                <Comment :commenter="'项目经理反馈'" :content="managerFeedback"></Comment>
              </a-row>
            </a-col>
          </a-space>
        </a-row>
      </a-layout-content>
      <a-layout-footer>Footer</a-layout-footer>
    </a-layout>
  </div>
</template>

<script>
import Comment from "./Comment";

export default {
  name: 'GiveScore',
  components: {
    Comment
  },
  // 属性区
  data() {
    return {
      myScore: {
        total: 98,
        process: 100,
        docs: 95,
        completion: 95,
        presentation: 100
      },
      teacherFeedback: '你在本次项目过程中团队意识强，善于倾听他人的意见，乐于助人。你的技术水平也十分高超，感谢你对本次项目成功做出的贡献！',
      managerFeedback: '你在本次项目过程中团队意识强，善于倾听他人的意见，乐于助人。你的技术水平也十分高超，感谢你对本次项目成功做出的贡献！'
    }
  },
  // 钩子
  mounted() {
  },
  // 行为区
  methods: {

  }
}
</script>

<style>
#components-layout-demo-basic {
  width: 95%;
}
#components-layout-demo-basic .ant-layout-header{
  background: #7dbcea;
  color: #fff;
  font-size: 30px;
  text-align: center;
}
#components-layout-demo-basic .ant-layout-footer {
  background: #7dbcea;
  color: #fff;
}
#components-layout-demo-basic .ant-layout-footer {
  line-height: 1.5;
}

#components-layout-demo-basic .ant-layout-content {
  background: #fff;
  color: #000c17;
  min-height: 120px;
  line-height: 120px;
  text-align: center;
  font-size: 18px;
}
#components-layout-demo-basic > .ant-layout {
  margin-bottom: 48px;
}
#components-layout-demo-basic > .ant-layout:last-child {
  margin: 0;
}

</style>
