<template>
  <div class="commodity-main">
    <div class="commodity-detail">
      <div class="commodity-left">
        <img alt="" v-bind:src="this.commodity.commodityPicture">
      </div>
      <div class="commodity-right">
        <div>商品名称: {{ this.commodity.commodityName }}</div>
        <div>商品描述: {{ this.commodity.commodityDescribe }}</div>
        <div>商品价格: {{ this.commodity.commodityPrice }}</div>
        <input type="button" value="购买"/>
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
              <span class="message_time">{{ item.messageCreateTime }}</span>
              <span class="reply" @click="reply($event)">回复</span>
            </div>
            <div class="message_content">
              <!--父评论内容-->
              <div>{{ item.messageContent }}</div>
              <!--子评论内容-->
              <div v-for="(childItem,index) in item.childMessages" :key="index" class="sub_message">
                <!--头像-->
                <img alt="" class="message_img" v-bind:src="childItem.user.userHeadPortrait">
                <!--内容-->
                <div class="message_details">
                  <div class="message_label">
                    <span class="message_userName">{{ childItem.user.userNickname }}</span>
                    <span v-if="childItem.user.userRights==='ADMIN'" class="message_userLabel_admin">管理员</span>
                    <span v-if="childItem.user.userRights==='USER'" class="message_userLabel">游客</span>
                    <span class="message_time">{{ childItem.messageCreateTime }}</span>
                    <span class="reply" @click="reply($event)">回复</span>
                  </div>
                  <div class="message_content">
                    <div>{{ childItem.messageContent }}</div>
                  </div>
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
        commodityName: '',
        commodityPicture: '',
        commodityDescribe: '',
        commodityPrice: '',
      },
      comment: [
        {
          messageId: '',
          messageCommodityId: '',
          messageUserId: '',
          messageParentId: '',
          messageContent: '',
          messageCreateTime: '',
          user: {
            userId: '',
            userNickname: '',
            userHeadPortrait: '',
            userRights: ''
          },
          childMessages: [
            {
              messageId: '',
              messageCommodityId: '',
              messageUserId: '',
              messageParentId: '',
              messageContent: '',
              messageCreateTime: '',
              user: {
                userId: '',
                userNickname: '',
                userHeadPortrait: '',
                userRights: ''
              },
            },
          ]
        },
      ],
      input_textarea: '',
    }
  },
  created() {
    // 获取商品详细信息
    axios.get('commodity/queryCommodityById', {params: {id: this.$route.params.id}}).then(res => {
      this.commodity = res.data
    })
    // 获取商品留言信息
    axios.get('message/queryAllByCommodityId', {params: {CommodityId: this.$route.params.id}}).then(res => {
      this.comment = res.data
    }).catch(function (error) {
      console.log(error)
    });
  },
  methods: {
    // 评论提交
    textareaSubmit() {
      let params = new URLSearchParams();
      // 商品ID
      params.append("messageCommodityId", this.$route.params.id.toString())
      // 商品发布者ID
      params.append("messageUserId", 1)
      // 父评论ID
      params.append("messageCommodityId", null)
      // 评论内容
      params.append("messageContent", this.input_textarea)
      console.log("评论提交")
    },
    // 用户回复
    reply() {
      // 移动光标
      this.$refs.inputText.focus()
      console.log("回复")
    },
  }
}
</script>

<style scoped>
.commodity-main {
  margin: 30px auto;
  width: 1200px;
  height: auto;
  background: white;
  padding: 30px 10px;
  border-radius: 20px;
}

.commodity-detail {
  margin: 30px auto;
  display: flex;
  flex-grow: 1;
}

.commodity-left {
  margin: 0 20px;
}

.commodity-left img {
  width: 450px;
  border-radius: 20px;
}

.commodity-right * {
  margin: 20px 0;
  font-size: 20px;
}

.commodity-right input {
  width: 270px;
  height: 40px;
  border-width: 0;
  border-radius: 3px;
  background: #1E90FF;
  cursor: pointer;
  outline: none;
  font-family: Microsoft YaHei, serif;
  color: white;
  font-size: 17px;
}


/* 评论输入 */
.message_input {
  height: 200px;
  padding: 10px;
  border-style: solid;
  border-color: rgb(154, 149, 149);
  border-width: 1px;
  border-radius: 5px;
}

.input_textarea {
  width: 100%;
  height: 150px;
  box-sizing: border-box;
  resize: none;
  border: 0;
  outline: none;
  font-size: 17px;
  font-family: 'Mulish', -apple-system, 'Noto Serif SC', "PingFang SC", "Microsoft Yahei UI", "Microsoft Yahei", sans-serif;
  background: url("../../assets/comment_bg.png") 100% 100% no-repeat;
}

.input_button {
  width: 70px;
  height: 30px;
  border-radius: 5px;
  float: right;
  background-color: antiquewhite;
}

/*回复*/
.reply {
  float: right;
  color: rgb(64, 158, 255);
  cursor: pointer;
}

/* 评论 */
.sub_message {
  display: flex;
  width: 100%;
  padding-top: 10px;
  margin-top: 10px;
  overflow: hidden;
}

.father_message {
  border-bottom-style: solid;
  border-width: 1px;
  border-color: #9a9595;
}

.message_img {
  width: 50px;
  height: 50px;
  border-radius: 25px;
  margin-right: 10px;
  float: left;

}

.message_details {
  height: auto;
  flex-grow: 1;
}

.message_label {
  padding-top: 15px;
  padding-bottom: 15px;
}

/*用户标签*/
.message_userName {
  margin: 0 10px;
  width: 20px;
  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
  font-weight: bold;
}

.message_userLabel {
  font-size: 15px;
  background: rgba(130, 130, 130);
  color: #FFFFFF;
  margin: 3px;
  padding: 1px 10px;
  border-radius: 5px;
  font-family: "Times New Roman", Times, serif;
}

.message_userLabel_admin {
  font-size: 15px;
  background: rgba(255, 165, 30);
  color: #FFFFFF;
  margin: 3px;
  padding: 1px 10px;
  border-radius: 5px;
  font-family: "Times New Roman", Times, serif;
}

.message_time {
  padding: 0 10px;
  color: #919191;
}

/* 评论内容 */
.message_content {
  padding-top: 15px;
  padding-bottom: 15px;
}
</style>