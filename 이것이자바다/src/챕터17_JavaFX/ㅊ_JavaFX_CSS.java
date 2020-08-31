package 챕터17_JavaFX;

public class ㅊ_JavaFX_CSS {
	// JavaFX UI를 담당하는 컨테이너 및 컨트롤은 CSS (Cascading Style Sheets)를 적용해서 모양 및 색상 등을 변경할 수 있다.
	// 이것은 HTML에 CSS를 적용하는 것과 유사하다. 다음은 JavaFX 애플리케이션에 CSS를 적용하면 UI 스킨이 어떻게 달라지는지 보여준다.
	
	//		[ 기본 CSS ]		[ 커스텀 CSS ]
	//		┌───┐			┌───┐
	//		│□ 1│			│■ 1│
	//		└───┘			└───┘
	
	// JavaFX CSS는 W3C CSS 버전의 2.1 스펙(http://www.w3.org/TR/CSS21/)에 따르기 때문에 CSS로 HTML 문서 스타일을 작성해본 개발자는 쉽게 JavaFX CSS를 정의할 수 있다.
	// 차이점은 JavaFX CSS 속성명은 W3C CSS 속성명 앞에 "-fx-"가 더 붙는다. JavaFX의 기본 CSS는 modena.css 파일에 작성되어 있다.
	// 이 파일은 JavaFX 런타임 JAR 파일 (jfxrt.jar) 안에 포함되어 있다. jfxrt.jar 파일은 <JDK 설치폴더> \jre\lib\ext 디렉토리에 저장되어 있는데,
	// 압축을 풀어 다음 경로로 가보면 modena.css를 찾을 수 있다.
	
	//	com/sun/javafx/scene/control/skin/modena/modena.css
	
	// 기본 CSS 대신 다른 모양과 색상을 주고 싶다면 커스텀 CSS를 정의하면 된다. 커스텀 CSS는 기본 CSS를 오버라이딩(재정의)해서 기본 속성을 변경하거나, 새로운 속성을 정의한 것을 말한다.
	// 커스텀 CSS를 적용하는 방법은 두 가지가 있다. 하나는 인라인(inline) 스타일로 컨테이너 또는 컨트롤의 style 속성을 이용해서 CSS를 직접 적용하는 것이고,
	// 다른 하나는 외부 CSS 파일을 생성하고 Scene에 적용하는 것이다. 이 두 방법에 대해 자세히 알아보기로 하자.
	
			//	Inline Style
	
	// 컨테이너 또는 컨트롤의 style 속성값으로 직접 CSS를 정의하기 때문에 쉽고, 빠르게 모양과 색상을 변경할 수 있다.
	
	//	<컨테이너 style	="속성:값; 속성:값; ...">
	//	<컨트롤 style	="속성:값; 속성:값; ...">
	
	// 다음 세 개의 Label을 FXML로 선언하고, style 속성을 이용해서 첫 번째 Label은 배경을 검은색, 글자는 노란색으로 CSS를 적용하고, 두 번째, 세 번째 Label은 배경을 파란색, 글자는 흰색으로 CSS를 적용했다.
	
	// -fx-background-color 속성은 배경색을 변경하고, -fx-text-fill 속성은 글자색을 변경한다. 그리고 -fx-padding 속성은 안쪽 여백인 패딩을 변경한다.
	
			//	Outside CSS File		외부 CSS 파일
	
	// 인라인 스타일은 컨테이너와 컨트롤의 style 속성으로 CSS를 직접 적용하기 때문에 동일한 스타일을 적용하는 컨테이너와 컨트롤이 많아질수록 중복 코드가 늘어나는 단점이 있다.
	// 또한 레이아웃과 CSS가 뒤섞여 추후 유지보수가 어렵다. 인라인 스타일 방법보다는 중복 코드를 줄이고, 재사용성을 높이면서 유지보수도 편리한 외부 CSS 파일을 작성해서 적용하는 것이 일반적이다.
	
			/*	Chooser		선택자	*/
	
	// 인라인 스타일은 해당 컨테이너 또는 컨트롤에 직접 스타일을 적용하기 때문에 선택자가 필요없지만, 외부 CSS 파일은 스타일을 적용할 컨테이너와 컨트롤을 선택해주는 선택자가 필요하다.
	// 다음은 선택자를 작성하는 방법을 보여준다.
	
	//	선택자 {
	//		속성:값; 속성:값;
	//	}
	
	// 선택자는 중괄호 {}에 정의된 CSS 속성을 적용할 컨테이너 또는 컨트롤을 선택하는 역할을 하는데, 다음 세 가지가 있다.
	
	//	선택자			작성 방법
	//
	//	Type 선택자		Type { 속성:값; 속성:값; }
	//
	//	id 선택자			#id { 속성:값; 속성:값; }
	//
	//	class 선택자		.class { 속성:값; 속성:값; }
	
	// Type 선택자는 같은 타입의 컨테이너 또는 컨트롤을 모두 선택한다. 예를 들ㄹ어 모든 Label 컨트롤의 안쪽 여백을 5만큼 주고 싶다면 다음과 같이 정의하면 된다.
	
	//	Label {													<Label ...>
	//		-fx-padding: 5;										<Label ...>
	//	}
	
	// #id 선택자는 동일한 id 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를 들어 id 속성값인 lblId인 Label의 배경을 검은색으로, 글자를 노란색으로 설정하고 싶다면 다음과 같이 정의하면 된다.
	
	//	#lblId {
	//		-fx-background-color: black;						<Label id="lblId">
	//		-fx-text-fill: yellow;
	//	}
	
	// .class 선택자는 동일한 styleClass 속성값을 가지고 있는 컨테이너 또는 컨트롤을 선택한다. 예를 들어 styleClass 속성값이 lblClass인 Label의 배경을 파란색으로,
	// 글자를 흰색으로 설정하고 싶다면 다음과 같이 정의하면 된다.
	
	//	.lblClass {
	//		-fx-background-color: blue;							<Label styleClass="lblClass">
	//		-fx-text-fill: white;								<Label styleClass="lblClass">
	//	}
	
	// FXML 파일에서 id 속성은 유일한 값을 가져야 하지만, styleClass 속성은 중복된 값을 가질 수 있다. 이 말은 id 선택자는 하나의 컨트롤만 선택할 수 있는 반면, 
	// class 선택자는 동시에 여러 컨트롤을 선택할 수 있다는 뜻이다. Type 선택자와 class 선택자는 조합이 가능하다.
	// 예를 들어 Label 컨트롤 중에서 styleClass="className"을 가진 것만으로 CSS를 적용하고 싶다면 다음과 같이 정의하면 된다.
	// 만약 Button 컨트롤이 styleClass="className"을 가지고 있다면 CSS는 적용되지 않는다.
	
	//	Label.className {
	//		-fx-background-color: blue;
	//		-fx-text-fill: white;
	//	}
	
	// 컨트롤은 세 가지 상태로 가질 수 있다. 입력 가능한 상태(focused), 마우스가 위에 있는 상태(hover), 마우스가 클릭한 상태(pressed)를 말하는데, 각 상태에 따라 스타일을 다르게 적용하고 싶다면
	// 선택자 다음에 :focused, :hover, :pressed를 붙이면 된다. 이런한 것들을 유사 클래스(pseudo-class)라고 한다.
		
	//	상태						상태별 선택자
	//	
	//	입력 가능한 상태				선택자:focused { 속성:값; 속성:값; }
	//	마우스가 컨트롤 위에 있는 상태		선택자:hover { 속성:값; 속성:값; }
	//	마우스로 컨트롤을 누른 상태		선택자:pressed { 속성:값; 속성:값; }
	
			/*	CSS File Application	CSS 파일 적용	*/
	
	// 이렇게 작성된 외부 CSS 파일은 개별 컨테이너 또는 컨트롤에 적용하거나 Scene에 추가하여 Scene 내부의 모든 컨테이너와 컨트롤을 적용할 수 있다.
	// 컨테이너 또는 컨트롤에 CSS 파일을 적용하려면 다음과 같이 FXML 파일에서 해당 태그의 stylesheets 속성으로 CSS 파일 경로를 지정하면 된다.
	
	//	<컨테이너 stylesheets="@app.css">
	
	// Scene에 적용하려면 Java 코드로 Scene의 getStylesheets() 메소드를 호출해서 ObservableList를 얻고 다음과 같이 CSS 파일 경로를 추가하면 된다.
	
	//	scene.getStylesheets().add(getClass().getResource("app.css").toString());
	
	// 다음 예제는 세 개의 Label에 CSS를 적용해서 배경색과 글자색을 변경하는데, 세 가지 선택자를 사용해 보았다.
	// 첫 번째 Label은 id 속성이 있고, 두 번째와 세 번째 Label은 styleClass 속성이 있으므로 이 속성들을 이용해서 선택자를 작성했다.
	
	// 모든 Label은 안쪽 여백을 5 가져야 되며, id가 lblId인 Label은 검은색, 글자는 노란색으로 적용하고, styleClass가 lblClass인 모든 Label은 배경을 파란색, 글자는 흰색으로 적용한다.
	
	// 다음 예제는 TextField와 Button 컨트롤의 상태에 따라서 스타일을 변경한다. 
	// TextField가 입력 가능한 상태가 되면 배경을 노란색, 마우스가 Button 위에 있으면 배경을 노란색으로, 클릭하면 빨간색으로 변경한다.
	
			//	Border Properties		Border 속성
	
	// Border 속성은 컨테이너 및 컨트롤의 경계선 스타일을 설정한다. 경계선의 굵기, 색상, 스타일, 내부 경계선의 위치를 설정할 수 있는 다음과 같은 세부 속성을 가지고 있다.
	
	//			속성				설명	
	//
	//	-fx-border-color		경계션의 색상
	//	-fx-border-insects		내부 경계션의 위치
	//	-fx-border-radius		둥근 모서리를 위한 원의 반지름
	//	-fx-border-style		경계션의 스타일(실선, 점선)
	//	-fx-border-width		경계선의 굵기
	
	// -fx-border-color 속성은 경계선의 색상을 설정하는데 다음과 같은 다양한 값들을 사용할 수 있다.
		
	//	-fx-border-color: red;						// 색이름
	//	-fx-border-color: #ff0000;					// #색상번호
	//	-fx-border-color: rgba(255, 0, 0, 0);		// rgba(red값, green값, blue값, 투명도)
	
	// rgba() 함수의 red, green, blue는 0 ~ 255 값을 가질 수 있고, 투명도는 0.0(투명) ~ 1.0(불투명) 값을 가진다.
	// 다음은 경계선을 빨간색으로, 굵기를 1픽셀로 설정한다.
	
	//	-fx-border-color: red;				┌───┐
	//	-fx-border-width: 1;				│ 	│
	//										└───┘

	//	-fx-border-color: red;				○───○
	//	-fx-border-width: 1;				│	│
	//	-fx-border-radius: 20;				○───○
	
	// JavaFX 컨테이너 및 컨트롤은 바깥 경계선 외에 내부 경계선을 여러 개 정의할 수 있다. -fx-border-insects 속성으로 경계선이 나타날 깊이를 쉼표로 구분해서 나열하면,
	// 다른 속성들도 경계선의 개수에 맞게 굵기, 색상, 스타일을 지정할 수 있다.
	// 다음은 3개의 경꼐선을 정의하고 각각 색상 및 굵기를 설정했다.
	
	//	-fx-border-insects: 0, 10, 20;						┌─────┐0
	//	-fx-border-color: redm green, blue					│┌───┐│10
	//	-fx-border-width: 1, 1, 1;							││┌─┐││20
	//														││└─┘││
	//														│└───┘│	
	//														└─────┘
	
	// 경계선은 top, right, bottom, left 별로 굵기, 색상, 스타일을 지정할 수 있다. 값의 순서는 top부터 시작하는 시계 방향으로 top, right, bottom, left로 나열해주면 된다.
	// 다음은 두 번째 경계선 top, bottom의 색상을 녹색으로 설정하고, 세 번째 경계선 right, bottom의 굵기를 3으로 설정했다.
	
	//	-fx-border-insects: 0, 10, 20;								┌───┐
	//	-fx-border-color: red, green white green white, blue;		│───│
	//	-fx-border-width: 1, 1, 1 3 3 1;							│┌─┐│
	//																│└─┘│
	//																│───│
	//																└───┘
	
	// -fx-border-style 속성은 실선과 점선을 설정하는데, solid(실선), dotted(점선), dashed(대시선)와 선의 길이 및 공백을 설정할 수 있는 segments()를 값으로 줄 수 있다.
	// segments()의 매개값은 홀수 번째 값은 길이를, 짝수 번째 값은 공백의 길이를 주면 된다.
	// 다음은 바깥 경계선의 top, right, bottom, left를 다른 스타일로 설정했다.
	
	//	-fx-border-color: red;												─────
	//	-fx-border-width: 2;												│	:
	//	-fx-border-style: solid dotted dashed segments(3, 2, 8, 2);			.ㅡㅡㅡ
	
	// 다음 예제는 FXML로 다섯 개의 VBox를 배치하고 border 속성을 다르게 적용하였다.
	
			//	Background Properties		Background 속성
	
	// background 속성은 컨테이너 및 컨트롤의 배경 스타일을 설정한다. 다음과 같이 배경 색상, 배경 이미지를 설정할 수 있는 세부 속성을 가지고 있다.
	
	//			속성						설명
	//	
	//	-fx-background-color		배경 색상
	//	-fx-background-image		배경 이미지
	//	-fx-background-position		배경 이미지 위치 (top, right, bottom, left, center)
	//	-fx-background-repeat		이미지 반복 여부 (no-repeat: 반복하지 않음)
	
	// -fx-background-color 속성은 배경 색상을 설정하는데, 단일 색상을 지정하는 방법은 다음과 같다.
	
	//	-fx-background-color: red;						// 색이름
	//	-fx-background-color: #ff0000;					// #색상번호
	//	-fx-background-color: rgba(255, 0, 0, 0);		// rgba(red값, green값, blue값, 투명도)
	
	// -fx-background-color에는 단일 색상 뿐만 아니라 선형 및 원형 그라디언트도 설정할 수 있다. 선형 그라디언트는 시작 색에서부터 끝 색까지 진행 방향으로 서서히 색상 변화를 준다.
	// 선형 그라디언트를 작성하는 방법은 다음과 같다.
	
	//	linear-gradient(to 진행방향, 시작색 S%, 중간색 M%..., 끝색);
	
	// 진행 방향은 to bottom, to right, to bottom right 등과 같이 밑으로, 오른쪽으로, 대각선으로 지정할 수 있다.				┌───┐
	// 각각의 색은 몇 % 정도가 나올지 S, M 값으로 지정할 수 있다. 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이 나온다.			│■□□│
	// 오른쪽은 다음과 같이 작성된 선형 그라디언트가 적용된 것이다.															└───┘
	
	//	-fx-background-color: linear-gradient(to right, black, white);
	
	// 원형 그라디언트는 시작 색에서 부터 끝 색까지 원형으로 서서히 색상 변화를 준다. 원형 그라디언트를 작성하는 방법은 다음과 같다.
	
	//	radial-gradient(center X% Y%, radius R%, 시작색 S%, 중간색 M%, 끝색);
	
	// X%와 Y%는 컨테이너 및 컨트롤의 좌상단을 0%, 0%로 보고, 원의 중심점이 위치하는 곳을 지정한다.										┌────┐
	// 예를들어 center 50% 50%는 원의 정중앙을 중심점으로 설정한다. R%는 중심점에서부터 색상 변화가 종료되는 위치이다.						│   ⊙	 │
	// 예를 들어 radius 50%는 컨테이너 및 컨트롤 전체 영역에 원형 그라디언트를 적용한다. 각각의 색이 몇 % 정도로 나올지 S, M 값으로 지정할 수 있다.		└────┘
	// 단, 끝 색은 % 값을 줄 수 없다. % 값이 생략되면 균등하게 색상이 나온다. 우측은 다음과 같이 작성된 원형 그라디언트가 적용된 것이다.					
	
	//	-fx-background-color: radial-gradient(center 50% 50%, radius 50%, #ffffff 10%, #000000);
	
	// -fx-background-image 속성은 배경 이미지를 설정한다. 배경 이미지보다 컨테이너 및 컨트롤의 사이즈가 더 크면 이비지는 반복적으로 드로잉 된다.
	// 한 번만 드로잉하려면 -fx-background-repeat 속성값을 no-repeat로 설정하면 된다. 그리고 이미지의 위치는 -fx-background-position으로 설정한다.
	// 다음은 배경 이미지를 설정하는 방법을 보여준다.
	
	//	-fx-background-image: url("이미지 경로");	// 이미지 파일 지정
	//	-fx-background-repeat: no-repeat;		// 한 번만 드로잉하도록 지정
	//	-fx-background-position: center;		// 정중앙에 위치하도록 지정
	
	// 다음 예제는 6개의 VBox에 차례대로 단색, 선형 그라디언트, 원형 그라디언트, 반복 이미지, 단일 이미지, 정중앙 단일 이미지를 적용한 것이다.
	
			//	Font Properties		Font 속성
	
	// font 속성은 글자의 스타일을 설정한다. 폰트 크기, 종류, 굵기, 색상 들을 설정할 수 있는 다음과 같은 세부 속성을 가지고 있다.
	
	//		속성				설명
	//
	//	-fx-font-size		폰트 크기
	//	-fx-font-family		폰트 종류
	//	-fx-font-weight		폰트 굵기(bold)
	//	-fx-font-fill		폰트 색상(단색, 선형 그라디언트, 원형 그라디언트)
	
	// 다음 예제는 Label 컨트롤의 폰트를 설정한다. 폰트 종류는 Arial Black, 크기는 35, 굵게, 색상은 선형 그라디언트를 적용했다.
	
			//	Shadow Effect		그림자 효과
	
	// JavaFX CSS는 그림자 효과를 주기 위해 -fx-effect 속성을 제공한다. 속성값으로 dropshadow()와 innershadow()를 줄 수 있는데,
	// dropshadow()는 바깥 그림자를 주어 튀어나오는 느낌을 주고, innershadow()는 안쪽 그림자를 주어 움푹 들어간 느낌을 준다.
	// dropshadow()와 innershadow()를 작성하는 방법은 다음과 같다.
	
	//	-fx-effect: dropshadow(three-pass-box , 그림자색상, radius, spread, offsetX, offsetY);
	//	-fx-effect: innershadow(three-pass-box , 그림자색상, radius, choke, offsetX, offsetY);
	
	// three-pass-box는 blur-type의 종류인데 gaussian, one-pass-box, two-pass-box, three-pass-box 등이 있다.
	// JavaFX는 three-pass-box를 기본으로 사용한다. radius는 blur kernel의 반지름으로 0.0 ~ 127.0 사이의 값을 가지는데, 기본값은 10이다.
	// spread와 choke는 각각 그림자의 spread와 choke로 0.0 ~ 1.0 사이의 값을 가지는데, 기본값은 0.0이다.
	// three-pass-box, radius, spread, choke는 이해하기가 쉽지 않기 때문에 보통은 기본값을 그대로 이용한다. offsetX와 offsetY는 그림자의 편차이다.
	// 다음 예제는 두 개의 버튼에 shadow 효과를 주었다. 첫 번째 버튼은 dropshadow()를 적용했고  두 번째 버튼은 innershadow()를 적용했다.
	
			//	Screen Skin Corver		화면 스킨 입히기
	
	// 지금까지 JavaFX CSS로 스타일을 적용하는 방법을 살펴보았다. 다음 예제에서는 학습한 내용을 활용해서 로그인 폼 화면을 만들고 CSS를 적용해서 스킨을 입혀 보았다.
	// 이 예제는 오라클의 JavaFX CSS 샘플 예제로 소개된 것이다. 마우스를 버튼 위로 올리거나 클릭하면 색상 변화를 볼 수 있다.
}
