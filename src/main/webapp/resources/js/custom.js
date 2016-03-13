$(function () {
    $('#menubar').resize(resizeMenubar);

    Dropzone.autoDiscover = false;
    myDropzone = new Dropzone("#filePreview", {
        acceptedFiles: "application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        url: "/upload?file=",
        maxFiles: 1,
        parallelUploads: 2,
        maxFilesize: 10,
        addRemoveLinks: true,
        autoProcessQueue: true,
        clickable: "#filePreview",
        previewsContainer: "#filePreview",
        dictRemoveFile: "Удалить файл",
        dictFileTooBig: "Размер файла превышен!",
        dictInvalidFileType: "Файл данного типа не поддерживается",
        dictMaxFilesExceeded: "Лимит файлов для загрузки исчерпан!",
        dictDefaultMessage: "Выберите файлы для загрузки",
        dictCancelUpload: "Отменить загрузку",

        error: function (file, response) {
            $.notify("<b>"+response+"</b>",
                {
                    type: "danger",
                    delay: 1000,
                    onClose: function () {
                        myDropzone.removeAllFiles();
                    }
                });
        },
        queuecomplete: function () {
            //saveProduct();
        },

        success: function (file, response) {
            if (response.status == "ok") {
                $.notify("<b>Файл успешно загружен</b>",
                    {
                        type: "success",
                        delay: 1000,
                        onClose: function () {
                            myDropzone.removeAllFiles();
                            location.href = "/";
                        }
                    });
            }
        }
    });


});

function resizeMenubar() {
    if ($('#menubar').width() == 64) {
        $('.button-text').hide();
    } else if ($('#menubar').width() == 150) {
        $('.button-text').show();
    }
}