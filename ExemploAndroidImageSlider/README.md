Slides no Android Com a Lib AndroidImageSlider




Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre libs úteis no dev Android, porém dessa vez mostrando a lib AndroidImageSlider que nos permite colocar a mesma feature de slides comum em sistemas Web no sistema mobile, mais precisamente na APP Android. A Lib AndroidImageSlider é fácil de configurar e utilizar, porém como no vídeo passado encontrei algumas limitações ao utilizar a lib, as limitações estão nos listeners disponíveis. Não encontrei o listener para o movimento de troca de slides e também não encontrei o listener de clique nos indicadores de slides, basicamente a única utilidade dos indicadores é visual. Também não encontrei um método que nos permite setar o slide atual. Todas as features que não encontrei acredito que dariam um poder maior a lib, mas mesmo sem elas o custo / beneficio da lib AndroidImageSlider ainda é muito válido devido ao slide funcionar como esperado (com imagens locais ou imagens vindas da Web) e ainda ter um listener de clique no slide que nos permite abrir uma outra entidade (Activity ou Fragment, por exemplo). Outra funcionalidade importante da lib é o auto ajuste da imagem no quadrante que foi determinado para o SliderLayout, porém mesmo assim é ainda necessário o uso de imagens adequadas para cada densidade de tela (falo sobre imagens e densidade de tela nesse vídeo: Suporte de Tela com Drawable DPI no Android), no exemplo não fiz essa adequeção, pois é somente um exemplo (I'm lazy, now). Para os slides, se quiser com descrição utilize a entidade TextSliderView e se quiser sem descrição (visivel, pois o método description() ainda continua funcionando) utilize a entidade DefaultSliderView. A lib AndroidImageSlider também permite a customização do indicador (apresentada uma no vídeo), do efeito de transação, do Slider view e da view que apresenta a descrição. Então é isso, vou evitar mais delongas e deixar você assistir ao vídeo.

Obs. : não esqueça do atributo xmlns:custom="http://schemas.android.com/apk/res-auto" no tag XML root de seu layout que tem o SliderLayout.

O link para download do projeto se encontra logo abaixo no post.

Segue links das páginas apresentadas no vídeo:

Página inicial da lib AndroidImageSlider no Github

https://github.com/daimajia/AndroidImageSlider

Página da Wiki da lib AndroidImageSlider no Github

https://github.com/daimajia/AndroidImageSlider/wiki

Vlw