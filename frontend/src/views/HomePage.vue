<template>
  <div :class="[multipage === true ? 'multi-page':'single-page', 'not-menu-page', 'home-page']">
    <a-row :gutter="8" class="head-info">
      <a-card class="head-info-card">
        <a-col :span="12">
          <div class="head-info-avatar">
            <img alt="头像" :src="avatar">
          </div>
          <div class="head-info-count">
            <div class="head-info-welcome">
              {{welcomeMessage}}
            </div>
            <div class="head-info-desc">
              <p>{{user.roleName ? user.roleName : '暂无角色'}}</p>
            </div>
            <div class="head-info-time">上次登录时间：{{user.lastLoginTime ? user.lastLoginTime : '第一次访问系统'}}</div>
          </div>
        </a-col>
        <a-col :span="12">
          <div>
            <a-row class="more-info">
              <a-col :span="4"></a-col>
              <a-col :span="4"></a-col>
              <a-col :span="4"></a-col>
              <a-col :span="4">
                <head-info title="今日IP" :content="todayIp" :center="false" :bordered="false"/>
              </a-col>
              <a-col :span="4">
                <head-info title="今日访问" :content="todayVisitCount" :center="false" :bordered="false"/>
              </a-col>
              <a-col :span="4">
                <head-info title="总访问量" :content="totalVisitCount" :center="false" />
              </a-col>
            </a-row>
          </div>
        </a-col>
      </a-card>
    </a-row>
    <a-row :gutter="8" class="count-info">
      <a-col :span="12" class="visit-count-wrapper">
        <a-card class="visit-count">
          <div  id="countChart" style="height: 400px;border:1px solid  #f1f1f1;border-radius: 5px" ></div>
        </a-card>
      </a-col>
      <a-col :span="12" class="project-wrapper">
        <a-card title="进行中的任务" class="project-card" v-if="loadRepo === 1">
          <dv-scroll-board :config="lunboConfig" style="width:100%;height:320px" />
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>
<script>
import HeadInfo from '@/views/common/HeadInfo'
import {mapState} from 'vuex'
import moment from 'moment'
import RunningTask from './common/RunningTask'
moment.locale('zh-cn')
export default {
  name: 'HomePage',
  components: {RunningTask, HeadInfo},
  data () {
    return {
      series: [],
      projects: [],
      todayIp: '',
      todayVisitCount: '',
      totalVisitCount: '',
      userRole: '',
      userDept: '',
      lastLoginTime: '',
      welcomeMessage: '',
      loadRepo: 0,
      htmlspan: '<span style="display:inline-block;margin-right: 5px;border-radius: 10px;width: 10px;height: 10px;background-color: ',
      legends: ['总数', '您'],
      myChart: {},
      // 轮播板的数据
      lunboConfig: {
        header: ['任务名', '责任单位', '历时估计'],
        data: [
          ['<span style="color:#000000;">撰写项目章程</span>', '<span style="color:#000000;">项目经理</span>', '<span style="color:#000000;">10天</span>'],
          ['<span style="color:#000000;">确定前端框架</span>', '<span style="color:#000000;">前端工程组</span>', '<span style="color:#000000;">5天</span>'],
          ['<span style="color:#000000;">确定后端框架</span>', '<span style="color:#000000;">后端工程组</span>', '<span style="color:#000000;">5天</span>'],
          ['<span style="color:#000000;">需求分析</span>', '<span style="color:#000000;">需求分析办公室</span>', '<span style="color:#000000;">30天</span>'],
          ['<span style="color:#000000;">软件架构设计</span>', '<span style="color:#000000;">软件架构师</span>', '<span style="color:#000000;">20天</span>'],
          ['<span style="color:#000000;">数据库设计</span>', '<span style="color:#000000;">数据库工作室</span>', '<span style="color:#000000;">10天</span>'],
          ['<span style="color:#000000;">开发及编码</span>', '<span style="color:#000000;">所有开发部门</span>', '<span style="color:#000000;">60天</span>'],
          ['<span style="color:#000000;">测试软件及修复</span>', '<span style="color:#000000;">测试部门</span>', '<span style="color:#000000;">20天</span>'],
          ['<span style="color:#000000;">进行验收测试</span>', '<span style="color:#000000;">开发部门及市场部门</span>', '<span style="color:#000000;">5天</span>'],
          ['<span style="color:#000000;">整理项目文档</span>', '<span style="color:#000000;">文档管理员</span>', '<span style="color:#000000;">3天</span>'],

        ],
        index: true,
        columnWidth: [50],
        align: ['center'],
        // headerBGC: '#74a3e1',
        oddRowBGC: '#ffffff',
        evenRowBGC: '#d1dcf0',
        rowNum: 8

      }


    }
  },
  computed: {
    ...mapState({
      multipage: state => state.setting.multipage,
      user: state => state.account.user
    }),
    avatar () {
      return `static/avatar/${this.user.avatar}`
    }
  },
  methods: {
    welcome () {
      const date = new Date()
      const hour = date.getHours()
      let time = hour < 6 ? '早上好' : (hour <= 11 ? '上午好' : (hour <= 13 ? '中午好' : (hour <= 18 ? '下午好' : '晚上好')))
      let welcomeArr = [
        '喝杯咖啡休息下吧☕',
        '要不要和朋友打局LOL',
        '要不要和朋友打局王者荣耀',
        '几天没见又更好看了呢😍',
        '今天又写了几个Bug🐞呢',
        '今天在群里吹水了吗',
        '今天吃了什么好吃的呢',
        '今天您微笑了吗😊',
        '今天帮助别人解决问题了吗',
        '准备吃些什么呢',
        '周末要不要去看电影？'
      ]
      let index = Math.floor((Math.random() * welcomeArr.length))
      return `${time}，${this.user.username}，${welcomeArr[index]}`
    },
    getRepos () {
      this.$originalGet('https://api.github.com/users/wuyouzhuguli/repos').then((r) => {
        r.data.forEach(repo => {
          let project = {}
          project.id = repo.id
          project.name = repo.name
          project.description = repo.description
          project.avatar = repo.name.substring(0, 1).toUpperCase()
          this.projects.push(project)
        })
      }).catch(error => {
        console.log(error)
      })
    },
    runningProject () {
      let that = this
      this.$get(`index/${this.user.username}`).then((r) => {
        let data = r.data.data
        this.todayIp = data.todayIp
        this.todayVisitCount = data.todayVisitCount
        this.totalVisitCount = data.totalVisitCount
        let dateArr = []
        let totalSeries = {name: '总数', data: [], type: 'bar'}
        let yourSeries = {name: '您', data: [], type: 'bar'}
        for (let i = 6; i >= 0; i--) {
          let time = moment().subtract(i, 'days').format('MM-DD')
          let contain = false
          for (let o of data.lastSevenVisitCount) {
            if (o.days === time) {
              contain = true
              totalSeries.data.push(o.count)
            }
          }
          if (!contain) {
            totalSeries.data.push(0)
          }
          dateArr.push(time)
        }
        this.series.push(totalSeries)
        for (let i = 6; i >= 0; i--) {
          let time = moment().subtract(i, 'days').format('MM-DD')
          let contain = false
          for (let o of data.lastSevenUserVisitCount) {
            if (o.days === time) {
              contain = true
              yourSeries.data.push(o.count)
            }
          }
          if (!contain) {
            yourSeries.data.push(0)
          }
        }
        this.series.push(yourSeries)
        this.myChart.setOption({
          title: {
            text: '近7日系统访问记录',
            show: true,
            left: 10,
            top: 10
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'line'
            },
            formatter: function name (params) {
              let htmlTip = ''
              for (let i = 0; i < params.length; i++) {
                if (i === 0) {
                  htmlTip += params[i].axisValue + '<br />'
                }
                if (i === (params.length - 1)) {
                  htmlTip += (that.htmlspan + params[i].color + ';"></span>' + params[i].seriesName + ' : ' + params[i].value)
                } else {
                  htmlTip += (that.htmlspan + params[i].color + ';"></span>' + params[i].seriesName + ' : ' + params[i].value + '<br />')
                }
              }
              return htmlTip
            }
          },
          legend: {
            type: 'scroll',
            x: 'center',
            y: 'bottom',
            textStyle: {
              fontSize: '12'
            },
            data: this.legends
          },
          toolbox: {
            show: true,
            right: 20,
            top: 10,
            feature: {
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: true,
            data: dateArr,
            axisLabel: {
              textStyle: {
                fontSize: '12'
              }
            }
          },
          yAxis: {
            type: 'value',
            axisLabel: {
              formatter: '{value}',
              textStyle: {
                fontSize: '12'
              }
            }
          },
          grid: {
            left: '4%'
          },
          series: this.series
        }, true)
      }).catch((r) => {
        console.error(r)
        that.$message.error('获取首页信息失败')
      })
    }
  },
  created () {
    this.getRepos()
    this.loadRepo = 1
  },
  mounted () {
    this.welcomeMessage = this.welcome()
    this.myChart = this.$echarts.init(document.getElementById('countChart'))
    this.runningProject()
  }
}
</script>
<style lang="less">
  .home-page {
    .head-info {
      margin-bottom: .5rem;
      .head-info-card {
        padding: .5rem;
        border-color: #f1f1f1;
        .head-info-avatar {
          display: inline-block;
          float: left;
          margin-right: 1rem;
          img {
            width: 5rem;
            border-radius: 2px;
          }
        }
        .head-info-count {
          display: inline-block;
          float: left;
          .head-info-welcome {
            font-size: 1.05rem;
            margin-bottom: .1rem;
          }
          .head-info-desc {
            color: rgba(0, 0, 0, 0.45);
            font-size: .8rem;
            padding: .2rem 0;
            p {
              margin-bottom: 0;
            }
          }
          .head-info-time {
            color: rgba(0, 0, 0, 0.45);
            font-size: .8rem;
            padding: .2rem 0;
          }
        }
      }
    }
    .count-info {
      .visit-count-wrapper {
        padding-left: 0 !important;
        .visit-count {
          padding: .5rem;
          border-color: #f1f1f1;
          .ant-card-body {
            padding: .5rem 1rem !important;
          }
        }
      }
      .project-wrapper {
        padding-right: 0 !important;
        .project-card {
          border: none !important;
          .ant-card-head {
            border-left: 1px solid #f1f1f1 !important;
            border-top: 1px solid #f1f1f1 !important;
            border-right: 1px solid #f1f1f1 !important;
          }
          .ant-card-body {
            padding: 0 !important;
            table {
              width: 100%;
              td {
                width: 50%;
                border: 1px solid #f1f1f1;
                padding: .6rem;
                .project-avatar-wrapper {
                  display:inline-block;
                  float:left;
                  margin-right:.7rem;
                  .project-avatar {
                    color: #42b983;
                    background-color: #d6f8b8;
                  }
                }
              }
            }
          }
          .project-detail {
            display:inline-block;
            float:left;
            text-align:left;
            width: 78%;
            .project-name {
              font-size:.9rem;
              margin-top:-2px;
              font-weight:600;
            }
            .project-desc {
              color:rgba(0, 0, 0, 0.45);
              p {
                margin-bottom:0;
                font-size:.6rem;
                white-space:nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
              }
            }
          }
        }
      }
    }
  }
</style>
