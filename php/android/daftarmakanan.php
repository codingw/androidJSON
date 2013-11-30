<?php
$link = mysql_connect('localhost', 'root', 'root') or die('Cannot connect to the DB');
mysql_select_db('android', $link) or die('Cannot select the DB');

$query = "SELECT nama_makanan, harga FROM tbl_makanan";
$result = mysql_query($query, $link) or die('Errorquery:  '.$query);

$rows = array();
while ($r = mysql_fetch_assoc($result)) {
    $rows[] = $r;
}
$data = "{makanan:".json_encode($rows)."}";
echo $data;
?>
