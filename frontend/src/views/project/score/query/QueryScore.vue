<template>
  <el-cascader-panel :options="selectorOptions"></el-cascader-panel>
</template>

<script>
export default {
  data() {
    return {
      // 选择打分对象的级联选项
      selectorOptions: [
        {
          value: '1',
          label: '选项1',
          children: [
            {
              value: '1.1',
              label: '选项1.1'
            },
            {
              value: '1.2',
              label: '选项1.2'
            }
          ]
        },
        {
          value: '2',
          label: '选项2',
          children: [
            {
              value: '2.1',
              label: '选项2.1'
            },
            {
              value: '2.2',
              label: '选项2.2'
            }
          ]
        }
      ]

    };
  }
};
</script>
