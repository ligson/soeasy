/**
 * Created by SanKai on 2016/4/7.
 */
$(function () {
    $("#reg_form").bootstrapValidator({
        message: '输入格式不正确！',
        feedbackIcons: {
            //valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '请输入用户名',
                validators: {
                    notEmpty: {
                        message: '该项不能为空!'
                    },
                    remote: {
                        url: 'remote.php',
                        message: 'The username is not available'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码禁止为空！'
                    }
                }
            },
            password2: {
                validators: {
                    notEmpty: {
                        message: '密码禁止为空！'
                    },
                    different: {
                        field: 'password',
                        message: '两次输入不一致'
                    }
                }
            }
        }
    });
});

/***
 *remote: {
                        url: 'remote.php',
                        message: 'The username is not available'
                    },
 different: {
                        field: 'password',
                        message: 'The username and password cannot be the same as each other'
                    }
 */