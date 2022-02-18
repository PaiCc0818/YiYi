<template>
  <div class="box">
    <div>商品名称：<input type="text"></div>
    <div>商品价格：<input type="text"></div>
    <div>商品详情：<textarea/></div>
    <div>商品分类：<input type="text"></div>
    <div>添加图片：<input type="text"></div>
  </div>
</template>

<script>
export default {
  name: "Release",
  methods: {}
}
</script>

<style scoped>
.box {
  margin: 30px auto;
  z-index: -1;
  width: 1200px;
  height: auto;
  background: white;
  padding: 30px 0;
  border-radius: 20px;
  text-align: center;
  font-size: 30px;
  font-weight: bold;
  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
  line-height: 100px;
}

</style>