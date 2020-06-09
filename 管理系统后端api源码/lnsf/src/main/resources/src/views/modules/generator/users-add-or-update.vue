<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户账号" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户账号"></el-input>
    </el-form-item>
    <el-form-item label="用户密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="用户密码"></el-input>
    </el-form-item>
    <el-form-item label="用户头像" prop="faceImage">
      <el-input v-model="dataForm.faceImage" placeholder="用户头像"></el-input>
    </el-form-item>
    <el-form-item label="昵称" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder="昵称"></el-input>
    </el-form-item>
    <el-form-item label="粉丝人数" prop="fansCounts">
      <el-input v-model="dataForm.fansCounts" placeholder="粉丝人数"></el-input>
    </el-form-item>
    <el-form-item label="关注人数" prop="followCounts">
      <el-input v-model="dataForm.followCounts" placeholder="关注人数"></el-input>
    </el-form-item>
    <el-form-item label="用户状态" prop="userStatus">
      <el-input v-model="dataForm.userStatus" placeholder="用户状态"></el-input>
    </el-form-item>
    <el-form-item label="用户接受到的赞美的数量" prop="receiveLikeCounts">
      <el-input v-model="dataForm.receiveLikeCounts" placeholder="用户接受到的赞美的数量"></el-input>
    </el-form-item>
    <el-form-item label="用户隐私" prop="userHidden">
      <el-input v-model="dataForm.userHidden" placeholder="用户隐私"></el-input>
    </el-form-item>
    <el-form-item label="学生证照片" prop="userFaces">
      <el-input v-model="dataForm.userFaces" placeholder="学生证照片"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          username: '',
          password: '',
          faceImage: '',
          nickname: '',
          fansCounts: '',
          followCounts: '',
          userStatus: '',
          receiveLikeCounts: '',
          userHidden: '',
          userFaces: ''
        },
        dataRule: {
          username: [
            { required: true, message: '用户账号不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '用户密码不能为空', trigger: 'blur' }
          ],
          faceImage: [
            { required: true, message: '用户头像不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '昵称不能为空', trigger: 'blur' }
          ],
          fansCounts: [
            { required: true, message: '粉丝人数不能为空', trigger: 'blur' }
          ],
          followCounts: [
            { required: true, message: '关注人数不能为空', trigger: 'blur' }
          ],
          userStatus: [
            { required: true, message: '用户状态不能为空', trigger: 'blur' }
          ],
          receiveLikeCounts: [
            { required: true, message: '用户接受到的赞美的数量不能为空', trigger: 'blur' }
          ],
          userHidden: [
            { required: true, message: '用户隐私不能为空', trigger: 'blur' }
          ],
          userFaces: [
            { required: true, message: '学生证照片不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/users/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.username = data.users.username
                this.dataForm.password = data.users.password
                this.dataForm.faceImage = data.users.faceImage
                this.dataForm.nickname = data.users.nickname
                this.dataForm.fansCounts = data.users.fansCounts
                this.dataForm.followCounts = data.users.followCounts
                this.dataForm.userStatus = data.users.userStatus
                this.dataForm.receiveLikeCounts = data.users.receiveLikeCounts
                this.dataForm.userHidden = data.users.userHidden
                this.dataForm.userFaces = data.users.userFaces
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/users/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'faceImage': this.dataForm.faceImage,
                'nickname': this.dataForm.nickname,
                'fansCounts': this.dataForm.fansCounts,
                'followCounts': this.dataForm.followCounts,
                'userStatus': this.dataForm.userStatus,
                'receiveLikeCounts': this.dataForm.receiveLikeCounts,
                'userHidden': this.dataForm.userHidden,
                'userFaces': this.dataForm.userFaces
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
