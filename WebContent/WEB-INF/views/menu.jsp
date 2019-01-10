<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

body {
	margin:0px;
	background-image: url("https://img.elo7.com.br/product/original/C79370/papel-de-parede-4e3-bd-adesivo-lanches.jpg");
    background-repeat: no-repeat;
	background-size: 1600px 800px;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 16px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: #424242;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 140px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.active {
  background-color:LightCoral;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}


button {
  background-color: LightCoral;
  color: white;
  border: none;
  padding: 17px 16px;
   text-align: center;
   marin-letf: 70%:
   width: auto;
 
}

button:hover {
  opacity: 0.8;
}


.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: black;
}


.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}


.modal {
  display: none; 
  position: fixed; 
  z-index: 1; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
  padding-top: 60px;
}


.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; 
  border: 1px solid #888;
  width: 30%; 
}


.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}


.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}


@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
</style>
</head>

<ul>
  <li><a class="active" href="/DonnaGula/">Home</a></li>
  
  <li class= "dropdown">
  <a href="javascript:void(0)" class= "dropbtn">Doces</a>
  <div class="dropdown-content">
      <a href="/DonnaGula/doces/cardapio">Cardápio</a>
      <a href="/DonnaGula/doces/form">Encomendar</a>

    </div></li>
 
 
 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Salgados</a>
    <div class="dropdown-content">
      <a href="/DonnaGula/salgados/cardapio">Cardápio</a>
      <a href="/DonnaGula/salgados/">Encomendar</a>
    </div>
  </li>
  <li>
 <button onclick="document.getElementById('id01').style.display='block'" style="float:right">Entrar</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="/action_page.php">
   

    <div class="container">
      <label for="uname"><b>Nome</b></label>
      <input type="text"  name="uname" required>

      <label for="psw"><b>Senha</b></label>
      <input type="password"  name="psw" required>
        
      <button type="submit">Entrar</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Lembra-me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancelar</button>
    </div>
  </form>
</div>

<script>

var modal = document.getElementById('id01');


window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
 
 </li>
  <li style="float:right">
    <a href="/DonnaGula/cliente/form" class="active">Cadastre-se</a>
    
    </li>
</ul>


</body>
</html>
