<template>
  <a-cascader
    :options="options"
    :load-data="loadData"
    placeholder="请选择学生"
    change-on-select
    @change="onChange"
  />
</template>
<script>
export default {
  data() {
    return {
      options: [
        {
          value: 'zhejiang',
          label: 'Zhejiang',
          isLeaf: false,
        },
        {
          value: 'jiangsu',
          label: 'Jiangsu',
          isLeaf: false,
        },
      ],
    };
  },
  methods: {
    onChange(value) {
      console.log(value);
    },
    loadData(selectedOptions) {
      const targetOption = selectedOptions[selectedOptions.length - 1];
      targetOption.loading = true;

      // load options lazily
      setTimeout(() => {
        targetOption.loading = false;
        targetOption.children = [
          {
            label: `${targetOption.label} Dynamic 1`,
            value: 'dynamic1',
          },
          {
            label: `${targetOption.label} Dynamic 2`,
            value: 'dynamic2',
          },
        ];
        this.options = [...this.options];
      }, 100);
    },
  },
};
</script>
