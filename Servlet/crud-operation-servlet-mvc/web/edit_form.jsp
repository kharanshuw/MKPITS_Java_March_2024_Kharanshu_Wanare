<%-- 
    Document   : edit_form
    Created on : Aug 4, 2024, 8:08:20 PM
    Author     : Kharanshu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form With Html & Css</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">





    <style>
        body {
            background: #C5E1A5;
        }



        form {
            width: 30%;
            margin: 60px auto;
            background: #efefef;
            padding: 60px 120px 80px 120px;
            text-align: center;
            -webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
            box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
        }


        label {
            display: block;
            position: relative;
            margin: 40px 0px;
        }

        .label-txt {
            position: absolute;
            top: -1.6em;
            padding: 10px;
            font-family: sans-serif;
            font-size: .8em;
            letter-spacing: 1px;
            color: rgb(120, 120, 120);
            transition: ease .3s;
        }


        .input {
            width: 100%;
            padding: 10px;
            background: transparent;
            border: none;
            outline: none;
        }

        .line-box {
            position: relative;
            width: 100%;
            height: 1px;
            background: #BCBCBC;
        }

        .line {
            position: absolute;
            width: 0%;
            height: 2px;
            top: 0px;
            left: 50%;
            transform: translateX(-50%);
            background: #8BC34A;
            transition: ease .6s;
        }

        .input:focus+.line-box .line {
            width: 100%;
        }

        .label-active {
            top: -3em;
        }

        button {
            display: inline-block;
            padding: 12px 24px;
            background: rgb(220, 220, 220);
            font-weight: bold;
            color: rgb(120, 120, 120);
            border: none;
            outline: none;
            border-radius: 3px;
            cursor: pointer;
            transition: ease .3s;
        }

        button:hover {
            background: #8BC34A;
            color: #ffffff;
        }

        /* 
button:disabled {
  cursor: not-allowed;
  pointer-events: all !important;
} */
    </style>
</head>

<body>
    
    

    <div>

        <form action="update" method="post">
            <h4 class="text-warning text-center pt-5">Edit information Page</h4>

	    Id:  <input type="text" name="id" value="${e.id}" readonly/>
            <label>
                <input type="text" class="input" name="email" placeholder="ENTER EMAIL" />
                <div class="line-box">
                    <div class="line"></div>
                </div>
            </label>

            <label>
                <input type="text" class="input" name="username" placeholder="ENTER USERNAME" />
                <div class="line-box">
                    <div class="line"></div>
                </div>
            </label>

            <label>
                <input type="text" class="input" name="country" placeholder="ENTER COUNTRY" />
                <div class="line-box">
                    <div class="line"></div>
                </div>
            </label>
	    
            <button type="submit">submit</button>
        </form>
    </div>
</body>

</html>