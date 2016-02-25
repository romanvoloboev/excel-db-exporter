<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="../../resources/js/jquery-1.11.2.min.js"></script>
<script src="../../resources/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/spin.min.js"></script>
<script src="../../resources/js/jquery.autosize.min.js"></script>
<script src="../../resources/js/jquery.nanoscroller.min.js"></script>
<script src="../../resources/js/effects.js"></script>
<script src="../../resources/js/jquery.resize.js"></script>
<script src="../../resources/js/dropzone.min.js"></script>
<script src="../../resources/js/bootstrap-notify.min.js"></script>
<script src="../../resources/js/custom.js"></script>
<%--<script src="../../assets/js/Demo.js"></script>--%>

<script type="text/javascript">
    $(function(){
        $.notifyDefaults({
            allow_dismiss: false,
            placement: {
                from: "top",
                align: "center"
            },
            animate: {
                enter: 'animated bounceInDown',
                exit: 'animated bounceOutUp'
            },
            offset: {
                y: 5
            }
        });
    })
</script>
