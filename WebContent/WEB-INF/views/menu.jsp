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
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: LightCoral;
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
</style>
</head>

<ul>
  <li><a href="/DonnaGula/">Home</a></li>
  
  <li class= "dropdown">
  <a href="javascript:void(0)" class= "dropbtn">Doces</a>
  <div class="dropdown-content">
      <a href="/DonnaGula/doces/cardapio">Card�pio</a>
      <a href="/DonnaGula/doces/form">Encomendar</a>

    </div></li>
 
 
 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Salgados</a>
    <div class="dropdown-content">
      <a href="/DonnaGula/salgados/cardapio">Card�pio</a>
      <a href="/DonnaGula/salgados/">Encomendar</a>
    </div>
  </li>
  
  <li class="dropdown">
    <a href="/DonnaGula/cliente/form">Cadastre-se</a>
    
    </li>
</ul>


</body>
</html>
