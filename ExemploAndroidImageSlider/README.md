Slides no Android Com a Lib AndroidImageSlider




Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre libs �teis no dev Android, por�m dessa vez mostrando a lib AndroidImageSlider que nos permite colocar a mesma feature de slides comum em sistemas Web no sistema mobile, mais precisamente na APP Android. A Lib AndroidImageSlider � f�cil de configurar e utilizar, por�m como no v�deo passado encontrei algumas limita��es ao utilizar a lib, as limita��es est�o nos listeners dispon�veis. N�o encontrei o listener para o movimento de troca de slides e tamb�m n�o encontrei o listener de clique nos indicadores de slides, basicamente a �nica utilidade dos indicadores � visual. Tamb�m n�o encontrei um m�todo que nos permite setar o slide atual. Todas as features que n�o encontrei acredito que dariam um poder maior a lib, mas mesmo sem elas o custo / beneficio da lib AndroidImageSlider ainda � muito v�lido devido ao slide funcionar como esperado (com imagens locais ou imagens vindas da Web) e ainda ter um listener de clique no slide que nos permite abrir uma outra entidade (Activity ou Fragment, por exemplo). Outra funcionalidade importante da lib � o auto ajuste da imagem no quadrante que foi determinado para o SliderLayout, por�m mesmo assim � ainda necess�rio o uso de imagens adequadas para cada densidade de tela (falo sobre imagens e densidade de tela nesse v�deo: Suporte de Tela com Drawable DPI no Android), no exemplo n�o fiz essa adeque��o, pois � somente um exemplo (I'm lazy, now). Para os slides, se quiser com descri��o utilize a entidade TextSliderView e se quiser sem descri��o (visivel, pois o m�todo description() ainda continua funcionando) utilize a entidade DefaultSliderView. A lib AndroidImageSlider tamb�m permite a customiza��o do indicador (apresentada uma no v�deo), do efeito de transa��o, do Slider view e da view que apresenta a descri��o. Ent�o � isso, vou evitar mais delongas e deixar voc� assistir ao v�deo.

Obs. : n�o esque�a do atributo xmlns:custom="http://schemas.android.com/apk/res-auto" no tag XML root de seu layout que tem o SliderLayout.

O link para download do projeto se encontra logo abaixo no post.

Segue links das p�ginas apresentadas no v�deo:

P�gina inicial da lib AndroidImageSlider no Github

https://github.com/daimajia/AndroidImageSlider

P�gina da Wiki da lib AndroidImageSlider no Github

https://github.com/daimajia/AndroidImageSlider/wiki

Vlw