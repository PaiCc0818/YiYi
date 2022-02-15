<template>
  <h1>发布</h1>
  <div class="btn_select" @click="selectLoadImg">
    <div>
      点击选择需要上传的图片
      <input type="file" name="file" accept="image/*"
             @change="changeImage()"
             ref="avatarInput"
             style="display: none"
      >
    </div>
  </div>
  <button type="submit" class="btn_submit" @click="upLoad">上传图片</button>
</template>

<script>
import axios from "axios";

export default {
  name: "Release",

  methods: {
    //js代码
    selectLoadImg() {
      this.$refs.avatarInput.dispatchEvent(new MouseEvent("click"));
    },
    changeImage() {
      let files = this.$refs.avatarInput.files;
      let that = this;

      function readAndPreview(file) {
        that.file = file
        if (/\.(jpe?g|png|gif)$/i.test(file.name)) {
          let reader = new FileReader();
          reader.onload = function () {
            if (that.imgData !== this.result) {
              that.imgData = this.result // 这个是base64的数据格式
            }
          };
          reader.readAsDataURL(file);
        }
      }
      if (files) {
        [].forEach.call(files, readAndPreview);
      }
    },
    upLoad() {
      let imgFile = this.file;//获取到上传的图片
      let formData = new FormData();//通过form data上传
      formData.append('file', imgFile)
      formData.append('userId', this.userId)
      axios.post('111').then((res) => {
        console.log(res.data);
      }).catch((error) => {
        console.log(error);
      })
    },
  }
}
</script>

<style scoped>

</style>