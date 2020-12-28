<template>
  <el-container>
    <el-header style="text-align: left">    <!--文字居左-->
      <div class="el-icon-folder" :style="{Height: Height + 'px'}">简易文件管理</div>

    </el-header>
    <el-main v-bind:style="{minHeight: Height+'px'}"><router-view/>

      <!--    table主要区域   -->
      <el-table :data="tableData.slice((query.currentPage-1)*query.pageSize, query.currentPage * query.pageSize)" style="width: 100%">
        <el-table-column  prop="id" label="ID" width="120" align="center" v-if="isShow">
        </el-table-column>
        <el-table-column prop="filename" label="文件名" width="500" show-overflow-tooltip><!--tooltip表格列内容过长时显示提示-->
        </el-table-column>
        <el-table-column prop="totalSizeName" label="文件大小" width="200">
        </el-table-column>
        <el-table-column prop="location" label="location" align="center" v-if="isShow">
        </el-table-column>
        <el-table-column prop="identifier" label="identifier" align="center" v-if="isShow">
        </el-table-column>
        <el-table-column prop="uploadTimeString" label="上传时间" width="300">
        </el-table-column>
        <el-table-column fixed="right" label="操作" align="center">
          <template slot-scope="scope">
            <el-button
                type="text"
                icon="el-icon-download"
                class="blue"
                @click="downloadHandle(scope.$index, scope.row)" size="small">下载</el-button>
<!--            <el-button-->
<!--                type="text"-->
<!--                icon="el-icon-download"-->
<!--                class="red"-->
<!--                @click="deleteHandle(scope.$index, scope.row)" size="small" disabled>删除</el-button>-->
          </template>
        </el-table-column>
      </el-table>
      <!--  table主要区域结束  -->

      <!--  分页 begin   -->
      <!--page-size设置每页几条数据-->
      <!--:total设置共几条数据-->
      <!--@current-change设置方法绑定点击页码事件-->
      <!--设置分页显示功能-->
      <el-pagination align="center"
                     background
                     @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="query.currentPage"
                     :page-sizes="[1,5,10,20]"
                     :page-size="query.pageSize"
                     layout="total, sizes, prev, pager, next, jumper"
                     :total="total">

      </el-pagination>
      <!--   分页  end   -->

    </el-main>
    <!--   主体内容结束     -->

    <el-footer>
      <li class="mr-3 mr-lg-0">© 2020 项目管理, Inc.All rights reserved.</li>
    </el-footer>
  </el-container>
</template>
<style>
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 80px;
}
.el-container {
  height: 100%;
}
body > .el-container {
  margin-bottom: 40px;
}

</style>

<script>
import UploadBigFile from './Upload';
import {selectFileList, deleteFile} from "@/api/modules/uploadFile";

export default {
  name: 'User',
  data() {
    return {
      query: {
        nameSearch: '',
        currentPage: 1,//当前页码
        pageSize: 5,   //每页5条数据
      },
      total: 0,
      Height: 0,       //固定底部不随主题内容上下浮动
      //tableData: Array(7).fill(item),    //填充测试数据
      tableData: [],
      nameSearch: '',
      isShow: false,
      uploadVisible: false,
      form: {},
      id: -1
    };
  },
  //  初始化
  created() {
    this.getData();
  },
  methods: {
    //从后台获取文件列表
    getData() {
      selectFileList(this.query).then(res => {
        this.tableData = res.data;
        this.total = res.data.length;

      })
    },

    //每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.query.currentPage = 1;
      this.query.pageSize = val;
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.query.currentPage = val;
    },

    //下载文件操作
    async downloadHandle(index, row) {
      this.loadingOverLay = this.$loading({
        lock: true,
        text: '文件生成中',
        spinner: 'el-icon-loading',
        background: 'rgba(0,0,0,0.7)'
      });
      var elemIF = document.createElement('iframe');
      //elemIF.src = `http://${process.env.BACKEND_API_HOST}`+'/uploader/download?id='+row.id+'&filename='+row.filename+'&location='+row.location;
      elemIF.style.display ='none';
      document.body.appendChild(elemIF);
      this.loadingOverLay.close();
    },

  },
  mounted() {
    //动态设置内容高度，让footer始终置底  120是header+footer高度
    this.Height = document.documentElement.clientHeight - 120;
    //监听浏览器窗口变化
    window.onresize = () => {this.Height = document.documentElement.clientHeight - 120}
  },
  components: {
    UploadBigFile
  }
};
</script>

<style scoped>
.handle-box {
  margin-top: -20px;
  margin-bottom: 0px;
}
.uploadSlot {
  margin: -10px 10px 10px 30px;
}
.red {
  color: #ff0000;
}
.mr10 {
  margin-right: 10px;
}
</style>
