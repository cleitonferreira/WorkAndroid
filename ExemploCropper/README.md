Cortando Imagens Com a Lib Cropper no Android





Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre libs úteis no Android mostrando a lib Cropper que nos permite colocar a funcionalidade de corte de imagem em nossas APPs Android. Com a view CropImageView setamos a imagem (via XML ou Java API) e então os controles de corte já são apresentados ao usuário indicando a possibilidade de corte. Funcionalidade comum em redes sociais quando o usuário fornece a imagem de perfil ele tem a opção de corta-la. Dê atenção a funcionalidade de rotação de imagem, apesar da lib Cropper nos permitir rotacionar a imagem ela nã0 permanece com o novo direcionamento, nós temos então que acessar o bitmap gerado via método getCroppedImage() e com o auxílio de um novo Bitmap e um objeto Matrix colocar a correta rotação da imagem, no vídeo mostro como fazer isso. Se sua APP tem formlário em que o usuário pode entrar com uma imagem colocar essa funcionalidade de crop pode enriquecer ainda mais a APP. No mais não tenho muito o que falar, pois é bem tranquilo utilizar a lib.

O link para download do projeto se encontra logo abaixo no post.

Segue link do post sobre a lib EventBus, que será útil se for enviar o novo Bitmap para alguma outra entidade de sua APP:

ButterKnife Lib, Simplificando Acesso a Views no Android

Segue link dá página da lib no GitHub:

Página da lib Cropper no GitHub

https://github.com/edmodo/cropper/

Vlw