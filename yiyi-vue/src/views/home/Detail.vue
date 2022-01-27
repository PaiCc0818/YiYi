<template>
  <div class="commodity-detail">
    <div class="commodity-left">
      <img alt="" v-bind:src="this.commodity.commodityPicture">
    </div>
    <div class="commodity-right">

    </div>
  </div>
  <div class="message">
    <!-- 评论输入框 -->
    <div class="message_input">
      <textarea ref="inputText" v-model="input_textarea" class="input_textarea" placeholder="来都来了讲点啥吧QWQ"/>
      <button class="input_button" type="button" @click="textareaSubmit">提交</button>
    </div>
    <!--评论展示框-->
    <div>
      <div v-for="(item,index) in comment" :key="index" class="sub_message father_message">
        <!--头像-->
        <img alt="" class="message_img" v-bind:src="item.user.userHeadPortrait">
        <!--内容-->
        <div class="message_details">
          <div class="message_label">
            <span class="message_userName">{{ item.user.userNickname }}</span>
            <span v-if="item.user.userRights==='ADMIN'" class="message_userLabel_admin">管理员</span>
            <span v-if="item.user.userRights==='USER'" class="message_userLabel">游客</span>
            <span class="message_time">{{ item.commentCreateTime }}</span>
            <span class="reply" @click="reply($event)">回复</span>
          </div>
          <div class="message_content">
            <!--父评论内容-->
            <div>{{ item.commentContent }}</div>
            <!--子评论内容-->
            <div v-for="(childItem,index) in item.childComments" :key="index" class="sub_message">
              <!--头像-->
              <img alt="" class="message_img" v-bind:src="childItem.user.userHeadPortrait">
              <!--内容-->
              <div class="message_details">
                <div class="message_label">
                  <span class="message_userName">{{ childItem.user.userNickname }}</span>
                  <span v-if="childItem.user.userRights==='ADMIN'" class="message_userLabel_admin">管理员</span>
                  <span v-if="childItem.user.userRights==='USER'" class="message_userLabel">游客</span>
                  <span class="message_time">{{ childItem.commentCreateTime }}</span>
                  <span class="reply" @click="reply($event)">回复</span>
                </div>
                <div class="message_content">
                  <div>{{ childItem.commentContent }}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Detail",
  data() {
    return {
      commodity: {
        commodityId: '',
        commodityTypeId: '',
        commodityUserId: '',
        commodityPicture: '',
        commodityDescribe: '',
        commodityPrice: '',
      },
      input_textarea: '',
    }
  },
  created() {
    axios.get('commodity/queryCommodityById', {params: {id: this.$route.params.id}}).then(res => {
      this.commodity = res.data
      console.log(this.commodity)
    })
  },
  methods: {
    // 用户提交评论
    textareaSubmit() {
      let params = new URLSearchParams();
      // 留言商品ID
      params.append("commentUserId", '1')
      // 留言用户ID
      params.append("commentUserId", '1')
      // 父留言ID
      params.append("commentUserId", '1')
      // 留言内容
      params.append("commentUserId", '1')
      // 留言时间
      params.append("commentUserId", '1')
      // 提交留言
      axios.post('/comment/insert', params).then(() => {
        this.input_textarea = "";
      })
    }
  }
}
</script>

<style scoped>
.commodity-detail {
  background: #66afe9;
  width: 1200px;
  margin: 30px auto;
}
</style>