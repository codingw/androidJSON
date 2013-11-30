<?php
$nama = $_GET['nama'];
$harga = $_GET['harga'];

$link = mysql_connect('localhost', 'root', 'root') or die('Cannot connect to the DB');
mysql_select_db('android', $link) or die('Cannot select the DB');

$query = "insert into tbl_makanan (nama_makanan,harga) values('".$nama."',".$harga.")";
$result = mysql_query($query, $link) or die('Error query:  '.$query);
echo "SUCCESS";

?>
