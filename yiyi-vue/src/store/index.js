import {createStore} from 'vuex'

export default createStore({
  state: {
    page: 1,
    commodity: [
      {
        commodityId: '',
        commodityUserId: '',
        commodityTypeId: '',
        commodityPicture: '',
        commodityDescribe: '',
        commodityPrice: '',
      }
    ],
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
