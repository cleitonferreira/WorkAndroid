Cortando Imagens Com a Lib Cropper no Android





Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre libs �teis no Android mostrando a lib Cropper que nos permite colocar a funcionalidade de corte de imagem em nossas APPs Android. Com a view CropImageView setamos a imagem (via XML ou Java API) e ent�o os controles de corte j� s�o apresentados ao usu�rio indicando a possibilidade de corte. Funcionalidade comum em redes sociais quando o usu�rio fornece a imagem de perfil ele tem a op��o de corta-la. D� aten��o a funcionalidade de rota��o de imagem, apesar da lib Cropper nos permitir rotacionar a imagem ela n�0 permanece com o novo direcionamento, n�s temos ent�o que acessar o bitmap gerado via m�todo getCroppedImage() e com o aux�lio de um novo Bitmap e um objeto Matrix colocar a correta rota��o da imagem, no v�deo mostro como fazer isso. Se sua APP tem forml�rio em que o usu�rio pode entrar com uma imagem colocar essa funcionalidade de crop pode enriquecer ainda mais a APP. No mais n�o tenho muito o que falar, pois � bem tranquilo utilizar a lib.

O link para download do projeto se encontra logo abaixo no post.

Segue link do post sobre a lib EventBus, que ser� �til se for enviar o novo Bitmap para alguma outra entidade de sua APP:

ButterKnife Lib, Simplificando Acesso a Views no Android

Segue link d� p�gina da lib no GitHub:

P�gina da lib Cropper no GitHub

https://github.com/edmodo/cropper/

Vlw