<template>
  <div class="box">
    <div>商品名称：<input type="text"></div>
    <div>商品价格：<input type="text"></div>
    <div>商品详情：<textarea/></div>
    <div>商品分类：<input type="text"></div>
    <div>添加图片：<input type="text"></div>
    <div><input accept="image/png,image/gif,image/jpeg" name="file" type="file" @change="update"/></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Release",
  methods: {
    update(e) {  // 上传照片
      const self = this;
      let file = e.target.files[0]
      /* eslint-disable no-undef */
      let param = new FormData() // 创建form对象
      param.append('file', file, file.name) // 通过append向form对象添加数据
      param.append('chunk', '0') // 添加form表单中其他数据
      console.log(param.get('file')) // FormData私有类对象，访问不到，可以通过get判断值是否传进去
      let config = {
        headers: {'Content-Type': 'multipart/form-data'}
      }
      // 添加请求头
      axios.post('http://172.19.26.60:8081/rest/user/headurl', param, config)
          .then(response => {
            if (response.data.code === 0) {
              self.ImgUrl = response.data.data
            }
            console.log(response.data)
          })
    }
  }
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