<template>
  <div>
    <a-card title="" style="{width: 100%; height: 100%}">
      <div id="title">
         {{ commenter }}
      </div>
      <br>
      <div id="cont">
        &nbsp &nbsp{{ content }}
      </div>
    </a-card>
  </div>
</template>

<script>
export default {
  name: 'Comment',
  props: ['commenter', 'content']
}
</script>

<style>
#title {
  font-size: 20px;
  color: #000c17;
  text-align: center;
}

  #cont {
    font-size: 18px;
    color: #1c1e21;
    text-align: left;
  }
</style>
