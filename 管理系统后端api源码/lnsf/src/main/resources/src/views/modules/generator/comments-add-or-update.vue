<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="回复其他用户留言时其他用户留言表的id" prop="fatherCommentId">
      <el-input v-model="dataForm.fatherCommentId" placeholder="回复其他用户留言时其他用户留言表的id"></el-input>
    </el-form-item>
    <el-form-item label="留言的用户id" prop="toUserId">
      <el-input v-model="dataForm.toUserId" placeholder="留言的用户id"></el-input>
    </el-form-item>
    <el-form-item label="留言的视频id" prop="videoId">
      <el-input v-model="dataForm.videoId" placeholder="留言的视频id"></el-input>
    </el-form-item>
    <el-form-item label="回复其他用户留言时其他用户的用户id" prop="fromUserId">
      <el-input v-model="dataForm.fromUserId" placeholder="回复其他用户留言时其他用户的用户id"></el-input>
    </el-form-item>
    <el-form-item label="评论内容" prop="comment">
      <el-input v-model="dataForm.comment" placeholder="评论内容"></el-input>
    </el-form-item>
    <el-form-item label="留言日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="留言日期"></el-input>
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
          fatherCommentId: '',
          toUserId: '',
          videoId: '',
          fromUserId: '',
          comment: '',
          createTime: ''
        },
        dataRule: {
          fatherCommentId: [
            { required: true, message: '回复其他用户留言时其他用户留言表的id不能为空', trigger: 'blur' }
          ],
          toUserId: [
            { required: true, message: '留言的用户id不能为空', trigger: 'blur' }
          ],
          videoId: [
            { required: true, message: '留言的视频id不能为空', trigger: 'blur' }
          ],
          fromUserId: [
            { required: true, message: '回复其他用户留言时其他用户的用户id不能为空', trigger: 'blur' }
          ],
          comment: [
            { required: true, message: '评论内容不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '留言日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/comments/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fatherCommentId = data.comments.fatherCommentId
                this.dataForm.toUserId = data.comments.toUserId
                this.dataForm.videoId = data.comments.videoId
                this.dataForm.fromUserId = data.comments.fromUserId
                this.dataForm.comment = data.comments.comment
                this.dataForm.createTime = data.comments.createTime
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
              url: this.$http.adornUrl(`/generator/comments/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'fatherCommentId': this.dataForm.fatherCommentId,
                'toUserId': this.dataForm.toUserId,
                'videoId': this.dataForm.videoId,
                'fromUserId': this.dataForm.fromUserId,
                'comment': this.dataForm.comment,
                'createTime': this.dataForm.createTime
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
