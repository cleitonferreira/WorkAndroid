Location API no Android, Atualiza��o de Localiza��o - Parte 2




Opa, blz?

Nesse v�deo parte 2 da s�rie de v�deos sobre a Location API no Android mostro como utilizar as entidades LocationRequest e LocationListener para manter o objeto de coordenadas da APP atualizado quanto ao local do usu�rio, mais precisamente do device. � importante entender o funcionamento dos m�todos setInterval() e setFastestInterval() para n�o se perder quanto as atualiza��es de coordenadas enviadas ao listener onLocationChanged() (que de vez em quando eu chamo de trigger no v�deo, mas ele � o listener). Fique atento tamb�m ao m�todo setPriority() que nos permiti setar qual ser� a forma priorit�ria de se utilizar o Fused Provider e n�o qual � o provider a ser utilizado. Nesse v�deo novamente n�o consegui ficar dentro dos 8 minutos, mas mesmo assim 14 minutos acredito que ficou em um tempo aceit�vel. Nessa implementa��o o update coordenadas est� rodando somente com a aplica��o aberta, provavelmente no �ltimo v�deo da s�rie eu vou postar uma implementa��o com ele rodando no background com um Service e ResultReceiver (esse �ltimo para quando a APP estiver aberta). Sem mais delongas, vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Segue links das p�ginas apresentadas no v�deo:

P�gina de implementa��o do Location updates no Android

https://developer.android.com/training/location/receive-location-updates.html

P�gina da classe LocationRequest no site de documenta��o do Android

https://developer.android.com/reference/com/google/android/gms/location/LocationRequest.html

�rea sobre o m�todo getSpeed() da classe Location no site de documenta��o do Android

http://developer.android.com/reference/android/location/Location.html#getSpeed()

Vlw