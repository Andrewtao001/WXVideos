const app = getApp()

Page({
  data: {
    faceUrl: "../resource/images/noneface.png",
    isMe: true,
    isFollow:false,
    publisherId: '',
    videoSelClass: 'video-info',
    isDisabled: true,
    isChecked: false,
  isSelectedWork:"video-info-selected",
  isSelectLike:"",
  isSelectedFollow:"",
    myVideoList: [],
    myVideoPage: 1,
    myVideoTotal: 1,

    likeVideoList: [],
    likeVideoPage: 1,
    likeVideoTotal: 1,

    followVideoList: [],
    followVideoPage: 1,
    followVideoTotal: 1,

    myWorkFalg: false,
    myLikesFalg: true,
    myFollowFalg: true
  },
  changeSwitch :function() {
    var that =this;
    var user = app.getGloalUserInfo();
    var userId = user.id;
    var serverUrl = app.serverUrl;
    var isChecked =!this.data.isChecked;
    wx.request({
      url: serverUrl + '/userVideo/hiddenVideos?userId=' + userId + '&isChecked='+isChecked,
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值
        'userId': user.id,
        'uniqueKey': user.userKey,
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if (res.data.status == 200) {
          that.setData({
            isChecked: isChecked
          });
          that.doSelectLike();
          that.doSelectFollow();
          that.doSelectWork();
        }else if (res.data.status == 502) {
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
          })
        }
      }
    })
  },
  onLoad: function (params) {
    var that=this;
    var user = app.getGloalUserInfo();
    var userId =user.id;
    var hidden2 = user.userHidden;
    //console.log(666 + hidden2);
    var serverUrl=app.serverUrl;
    var hidden =false;
    if (hidden2 == 1){
      hidden =true;
      that.setData({
        isChecked: hidden
      })
    }
    var publisherId = params.publisherId;
    if (publisherId != null && publisherId != '' && publisherId != undefined && publisherId != userId){
      userId =publisherId;
      that.setData({
        isMe: false,
        publisherId: userId, 
      })
    }
    wx.showLoading({
      title: '正在连接请等待',
    });
    // 调用后端
    wx.request({
      url: serverUrl + '/users/queryUsers?userId=' + userId+'&fanId='+user.id,
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值
        'userId': user.id,
        'uniqueKey': user.userKey,
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if (res.data.status == 200) {
         var userInfo = res.data.data;
          var faceUrl = "../resource/images/noneface.png";
          if (userInfo.faceImage != null && userInfo.faceImage !=''&& userInfo.faceImage !=undefined){
            faceUrl = serverUrl + userInfo.faceImage;
          }
          that.setData({
            faceUrl: faceUrl,
            fansCounts: userInfo.fansCounts  ,
            receiveLikeCounts: userInfo.receiveLikeCounts  ,
            followCounts: userInfo.followCounts,
            nickname: userInfo.nickname,
            isFollow: userInfo.follow
          }),

            that.doSelectWork();
        } else if (res.data.status == 502) {
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
            success:function(){
              wx.redirectTo({
                url: '../userLogin/login',
              })
            }
          })
        }
      }
    })

  },
  userManager: function(){
    wx.redirectTo({
      url: '../userManager/userManager',
    })
  },
  indexUser: function(){
    wx.redirectTo({
      url: '../index/index',
    })
  },
  doSelectWork: function () {
    this.setData({
      isSelectedWork: "video-info-selected",
      isSelectedLike: "",
      isSelectedFollow: "",

      myWorkFalg: false,
      myLikesFalg: true,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyVideoList(1);
  },

  doSelectLike: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "video-info-selected",
      isSelectedFollow: "",

      myWorkFalg: true,
      myLikesFalg: false,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyLikesList(1);
  },

  doSelectFollow: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "",
      isSelectedFollow: "video-info-selected",

      myWorkFalg: true,
      myLikesFalg: true,
      myFollowFalg: false,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyFollowList(1)
  },

  logout: function(param){
    var user = app.getGloalUserInfo(); 
    var serverUrl = app.serverUrl;
    // 调用后端
    wx.request({
      url: serverUrl + '/logout?userId='+user.id,
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值
        'userId': user.id,
        'uniqueKey': user.userKey,
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if(res.data.status==200){
          wx.showToast({
            title: '用户已注销',
            icon: 'success',
            duration:2000
          

          })
          wx.removeStorageSync("userInfo");
            //跳转到用户登录
            wx.redirectTo({
              url: '../userLogin/login',
            })
        }


      }
    })
  },
  followMe:function(e){
    var that =this;
    var user = app.getGloalUserInfo();
    var userId = user.id;
    var publisherId = that.data.publisherId;


    var  followType =e.currentTarget.dataset.followtype;
//1.关注 0.取消关注
var url ='';
    if (followType == '1'){
      url = '/users/addYourFans?userId=' + publisherId + '&fanId='+userId
    }else{
      url = '/users/delYourFans?userId=' + publisherId + '&fanId=' + userId
    }
    wx.showLoading({
      title: '正在访问后台数据',
    })
  
  wx.request({
    url: app.serverUrl+url,
    method: 'POST',
    header: {
      'content-type': 'application/json', // 默认值
      'userId': user.id,
      'uniqueKey': user.userKey,
    },
    success: function(){
        wx.hideLoading();
      if (followType == '1') {
        that.setData({
          isFollow:true,
          fansCounts: ++that.data.fansCounts
        })
      } else {
        that.setData({
          isFollow: false,
          fansCounts: --that.data.fansCounts
        })
      }
    }
  })
  },
  changeImage:function(){
    var that =this;
    wx.chooseImage({
      count: 1,
      sizeType: [ 'compressed'],
      sourceType: ['album', 'camera'],
      success(res) {
        // tempFilePath可以作为img标签的src属性显示图片
        const tempFilePaths = res.tempFilePaths;
        wx.showLoading({
          title: '上传图片中',
        })
        var serverUrl =app.serverUrl;
        var user = app.getGloalUserInfo(); 
          wx.uploadFile({
            url: serverUrl + '/users/upLoadImage?userId=' + user.id, 
            filePath: tempFilePaths[0],
            name: 'file',
            header: {
              'content-type': 'application/json', // 默认值
              'userId': user.id,
              'uniqueKey': user.userKey,
            },
            success:function(res) {
              const data = JSON.parse(res.data);
              console.log(data);
              //do something
              wx.hideLoading();
              if(data.status==200){
                wx.showToast({
                  title: '图片上传成功',
                  icon: 'success',
                });
                var imageUrl =data.data;
                that.setData({
                  faceUrl:serverUrl+imageUrl
                })

              } else if (res.data.status == 502) {
                wx.showToast({
                  title: res.data.msg,
                  duration: 3000,
                  icon: "none",
                  success: function () {
                    wx.redirectTo({
                      url: '../userLogin/login',
                    })
                  }
                })
              }
              else if(data.status==500){
                wx.showToast({
                  title: res.data.msg,      
                })
              }
             
            }
          })
      }

    })
},
  uploadVideo:function(){
    var that =this;
    wx.chooseVideo({
      sourceType: ['album'],
      success(res) {
        //获取短视频时间长度
        var tempDuration =res.duration;
        var tempHeight =res.height;
        var tempWidth =res.width;
        var tempVideoUrl =res.tempFilePath;
        var tempPictureUrl = res.thumbTempFilePath;


        if (tempDuration > 31){
          wx.showToast({
            title: '视频长度不能超过30秒...',
            icon:"none",
            tempDuration: 2500
          })
        } else if (tempDuration < 3 ){
          wx.showToast({
            title: '视频长度不能短于3秒...',
            icon: "none",
            tempDuration: 2500
          })
        }
        else{
          //打开选择bgm的目录
              wx.navigateTo({
                url: '/pages/chooseBgm/chooseBgm?tempdruation=' + tempDuration
                  + "&tempHeight="+tempHeight
                  + "&tempVideoUrl=" + tempVideoUrl
                  + "&tempPictureUrl=" + tempPictureUrl
                  + "&tempWidth=" + tempWidth,
              })
        }
      }
    })
  },
  getMyVideoList: function (page) {
    var me = this;
    var user = app.getGloalUserInfo();
    var userId = user.id;
    console.log(me.data);
    console.log("aaa");
    var publisherId = me.data.publisherId;
    if (publisherId != null && publisherId != undefined && publisherId != '' && userId != publisherId) {
      userId = publisherId;
    }
    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
 
    wx.request({
      url: serverUrl + '/userVideo/showAllVideos?pages=' + page + '&pageSize=6',
      method: "POST",
      data: {
        userId: userId
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        var myVideoList = res.data.data.rows;
        wx.hideLoading();

        var newVideoList = me.data.myVideoList;
        me.setData({
          myVideoPage: page,
          myVideoList: newVideoList.concat(myVideoList),
          myVideoTotal: res.data.data.total,
          serverUrl: app.serverUrl
        });
      }
    })
  },

  getMyLikesList: function (page) {
    var me = this;
    var user = app.getGloalUserInfo();
    var userId = user.id;
    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/userVideo/showLikeVideos?userId=' + userId + '&pages=' + page + '&pageSize=6',
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        var likeVideoList = res.data.data.rows;
        wx.hideLoading();

        var newVideoList = me.data.likeVideoList;
        me.setData({
          likeVideoPage: page,
          likeVideoList: newVideoList.concat(likeVideoList),
          likeVideoTotal: res.data.data.total,
          serverUrl: app.serverUrl
        });
      }
    })
  },

  getMyFollowList: function (page) {
    var me = this;
    var user = app.getGloalUserInfo();
    var userId = user.id;

    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/userVideo/showFollowVideos?userId=' + userId + '&pages=' + page + '&pageSize=6',
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        var followVideoList = res.data.data.rows;
        wx.hideLoading();

        var newVideoList = me.data.followVideoList;
        me.setData({
          followVideoPage: page,
          followVideoList: newVideoList.concat(followVideoList),
          followVideoTotal: res.data.data.total,
          serverUrl: app.serverUrl
        });
      }
    })
  },
  // 点击跳转到视频详情页面
  showVideo: function (e) {

    console.log(e);

    var myWorkFalg = this.data.myWorkFalg;
    var myLikesFalg = this.data.myLikesFalg;
    var myFollowFalg = this.data.myFollowFalg;

    if (!myWorkFalg) {
      var videoList = this.data.myVideoList;
    } else if (!myLikesFalg) {
      var videoList = this.data.likeVideoList;
    } else if (!myFollowFalg) {
      var videoList = this.data.followVideoList;
    }

    var arrindex = e.target.dataset.arrindex;
    var videoInfo = JSON.stringify(videoList[arrindex]);

    wx.redirectTo({
      url: '../videoinfo/videoinfo?videoInfo=' + videoInfo
    })

  },

  // 到底部后触发加载
  onReachBottom: function () {
    var myWorkFalg = this.data.myWorkFalg;
    var myLikesFalg = this.data.myLikesFalg;
    var myFollowFalg = this.data.myFollowFalg;

    if (!myWorkFalg) {
      var currentPage = this.data.myVideoPage;
      var totalPage = this.data.myVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyVideoList(page);
    } else if (!myLikesFalg) {
      var currentPage = this.data.likeVideoPage;
      var totalPage = this.data.myLikesTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyLikesList(page);
    } else if (!myFollowFalg) {
      var currentPage = this.data.followVideoPage;
      var totalPage = this.data.followVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyFollowList(page);
    }

  }


}
)
