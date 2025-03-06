<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup Form</title>
</head>
<body>
<section>
    <form action="/api/kitchensink/register" method="post">
        <h1>Sign Up</h1>
        <div class="inputbox">
            <input type="text" id= "name" name="name" required>
            <label for="">Name</label>
        </div>
        <div class="inputbox">
            <input type="email" id="email" name="email" required>
            <label for="">Email</label>
        </div>
        <div class="inputbox">
            <input type="text" id="phoneNumber" name="phoneNumber" required>
            <label for="">Phone#</label>
        </div>
        <button id= "submit" type="submit">Sign Up</button>
    </form>
</section>
</body>
</html>
<script>
    const submitButttom = document.getElementById("submit");
    submitButttom.addEventListener('click',()=> {
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const phoneNumber = document.getElementById('phoneNumber').value;
        const data = {
            username,
            email,
            phoneNumber
        }


        const jsonData = JSON.stringify(data);
        fetch('/api/kitchensink/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: jsonData
        })
            .then(response => {
                alert('succesfull');
                if(response.status == 200){
                alert('succesfull');}
                //xs}
            })


    })


</script>