var cmm_vue = cmm_vue || {}
cmm_vue = {
	head : ()=>{
		return `<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, viewport-fit=cover">
			<meta name="description" content="빠르고 저렴하게 해외로 돈을 보낼 수 있는 해외송금서비스, 중국송금, 일본송금, 싱가포르송금, 미국송금, 호주송금">
			<meta property="og:type" content="website">
			<meta property="og:title" content="머니허브(MoneyHub) 해외송금">
			<meta property="og:description" content="빠르고 저렴하게 해외로 돈을 보낼 수 있는 해외송금서비스">
			<meta property="og:image" content="https://img.themoin.com/public/img/meta_link_thumbnail.png">
			<meta property="og:url" content="https://www.themoin.com">
			<meta name="application-name" content="머니허브(MoneyHub) 해외송금">
			<meta name="msapplication-TileColor" content="#ffffff">
			<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
			<meta name="theme-color" content="#ffffff">
			<link rel="canonical" href="https://www.themoin.com">
			<link rel="alternate" hreflang="ko" href="https://www.themoin.com/ko">
			<link rel="alternate" hreflang="en" href="https://www.themoin.com/en">
			<link rel="alternate" hreflang="x-default" href="https://www.themoin.com/">
		
			<!--카카오 css-->
			<link href="/web/resources/css/kabang.css" rel="stylesheet" type="text/css">
		
		
		<!-- Add a banner for Appstore link -->
			<meta name="apple-itunes-app" content="app-id=1228063143">
			<title>머니허브(MoneyHub) 해외송금</title>
			<link href="https://www.kakaobank.com/products_static/css/event/list/style.css" rel="stylesheet" type="text/css">

			<!-- Bootstrap core CSS -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
			<link href="/web/resources/css/moin.bundle.css" rel="stylesheet" type="text/css">
			<script src="/web/resources/js/exchart/Chart.min.js"></script>
		</head>`
	},
	footer : ()=>{
		return `<div class="themoin-footer">
			<div>
				<div class="section top">
					<div class="contact">
						<h3><b><a id="compo" class="">회사 소개</a></b></h3>
					</div>
					<div class="spacer"></div>
					<div class="social">
						<h3><b><a id="faq" class="">F A Q</a></b></h3>
					</div>
					<div class="spacer"></div>
					<div class="links">
		        		<h3><b><a id="event" class="">이벤트 페이지</a></b></h3>
					</div>
				</div>
				<div class="section bottom">
					<div class="company">
						<img src="/img/logo/gray_logo.png">
						<p>
									(주)머니허브 | 대표이사 : 양현미 | 사업자등록번호 : 123-45-67890
									<br>
									소액해외송금업 등록번호 : 2019-12
									<br>
									주소 : 서울시 마포구 백범로 23 구프라자 3층
									<br>
									© 2019 MONEYHUB, Inc. All Rights Reserved.
								</p>
					</div>
					<div class="spacer"></div>
				</div>
			</div>
		</div>`
	}
}