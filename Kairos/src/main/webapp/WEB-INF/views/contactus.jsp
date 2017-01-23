<html>
    <head>
        <title>Contact Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <%@include file="include/links.jsp" %>
       <%@include file="include/header.jsp" %>
       <%@include file="include/Navbar.jsp" %>
    </head>
    <body>
    
    
    
    <br>
    <br>

        <div class="row">

              
              
                <div class="col-lg-8 col-lg-offset-1">
                
           
 <c:if test="${Reply !=null}">
          
          <div class="error" style="color:rgb(0,128,0);">  ${Reply}</div></c:if>
            

                    <h1>Contact form</h1>
 <br>

                    <form id="contact-form" method="post" action="<c:url value="/contactsubmit" />" role="form">

    <div class="messages"></div>

    <div class="controls">

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_name">Firstname <span style="color:red">*</span></label>
                    <input id="form_name" type="text" name="name" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_lastname">Lastname</label>
                    <input id="form_lastname" type="text" name="surname" class="form-control" placeholder="Please enter your lastname" required="required" data-error="Lastname is required.">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_email">Email<span style="color:red">*</span></label>
                    <input id="form_email" type="email" name="email" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_phone">Phone</label>
                    <input id="form_phone" type="tel" name="phone" class="form-control" placeholder="Please enter your phone">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="form_message">Message <span style="color:red">*</span></label>
                    <textarea id="form_message" name="message" class="form-control" placeholder="Message for me *" rows="4" required="required" data-error="Please,leave us a message."></textarea>
                    <div class="help-block with-errors"></div>
                </div>
            </div> <br>
            <div class="col-md-12">
                <button id="btnsubmit" type="submit" class="btn btn-success btn-send" value="Send message">Send Message</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="text-muted"><strong> <span style="color:red">*</span></strong> These fields are required</p>
            </div>
        </div>
    </div>

</form>

                </div>

            </div>

       
        
    </body>
</html>