<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="问题一" prop="question1">
      <el-input v-model="dataForm.question1" placeholder="问题一"></el-input>
    </el-form-item>
    <el-form-item label="问题二" prop="question2">
      <el-input v-model="dataForm.question2" placeholder="问题二"></el-input>
    </el-form-item>
    <el-form-item label="问题三" prop="question3">
      <el-input v-model="dataForm.question3" placeholder="问题三"></el-input>
    </el-form-item>
    <el-form-item label="答案一" prop="answer1">
      <el-input v-model="dataForm.answer1" placeholder="答案一"></el-input>
    </el-form-item>
    <el-form-item label="答案二" prop="answer2">
      <el-input v-model="dataForm.answer2" placeholder="答案二"></el-input>
    </el-form-item>
    <el-form-item label="答案三" prop="answer3">
      <el-input v-model="dataForm.answer3" placeholder="答案三"></el-input>
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
          userId: '',
          question1: '',
          question2: '',
          question3: '',
          answer1: '',
          answer2: '',
          answer3: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          question1: [
            { required: true, message: '问题一不能为空', trigger: 'blur' }
          ],
          question2: [
            { required: true, message: '问题二不能为空', trigger: 'blur' }
          ],
          question3: [
            { required: true, message: '问题三不能为空', trigger: 'blur' }
          ],
          answer1: [
            { required: true, message: '答案一不能为空', trigger: 'blur' }
          ],
          answer2: [
            { required: true, message: '答案二不能为空', trigger: 'blur' }
          ],
          answer3: [
            { required: true, message: '答案三不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/identityusers/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.identityUsers.userId
                this.dataForm.question1 = data.identityUsers.question1
                this.dataForm.question2 = data.identityUsers.question2
                this.dataForm.question3 = data.identityUsers.question3
                this.dataForm.answer1 = data.identityUsers.answer1
                this.dataForm.answer2 = data.identityUsers.answer2
                this.dataForm.answer3 = data.identityUsers.answer3
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
              url: this.$http.adornUrl(`/generator/identityusers/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'question1': this.dataForm.question1,
                'question2': this.dataForm.question2,
                'question3': this.dataForm.question3,
                'answer1': this.dataForm.answer1,
                'answer2': this.dataForm.answer2,
                'answer3': this.dataForm.answer3
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
