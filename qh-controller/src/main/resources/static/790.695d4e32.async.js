(self.webpackChunkant_design_pro=self.webpackChunkant_design_pro||[]).push([[790],{47828:function(){},61859:function(fe,D,l){"use strict";l.d(D,{Z:function(){return Xt}});var v=l(22122),n=l(67294),w=l(96156),X=l(90484),p=l(28481),H=l(79508),C=l(99165),$=l(28991),Ee={icon:{tag:"svg",attrs:{viewBox:"64 64 896 896",focusable:"false"},children:[{tag:"path",attrs:{d:"M257.7 752c2 0 4-.2 6-.5L431.9 722c2-.4 3.9-1.3 5.3-2.8l423.9-423.9a9.96 9.96 0 000-14.1L694.9 114.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2 1-7.1 2.9L256.8 538.8c-1.5 1.5-2.4 3.3-2.8 5.3l-29.5 168.2a33.5 33.5 0 009.4 29.8c6.6 6.4 14.9 9.9 23.8 9.9zm67.4-174.4L687.8 215l73.3 73.3-362.7 362.6-88.9 15.7 15.6-89zM880 836H144c-17.7 0-32 14.3-32 32v36c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-36c0-17.7-14.3-32-32-32z"}}]},name:"edit",theme:"outlined"},Ce=Ee,re=l(27029),G=function(r,a){return n.createElement(re.Z,(0,$.Z)((0,$.Z)({},r),{},{ref:a,icon:Ce}))};G.displayName="EditOutlined";var g=n.forwardRef(G),ve=l(94184),le=l.n(ve),K=l(20640),pe=l.n(K),vt=l(48717),Ne=l(50344),he=l(8410),pt=l(21770),De=l(98423),$e=l(42550),ze=l(53124),yt=l(42051),ke=l(34952),Ae=l(79370),Te=l(45777),mt={icon:{tag:"svg",attrs:{viewBox:"64 64 896 896",focusable:"false"},children:[{tag:"path",attrs:{d:"M864 170h-60c-4.4 0-8 3.6-8 8v518H310v-73c0-6.7-7.8-10.5-13-6.3l-141.9 112a8 8 0 000 12.6l141.9 112c5.3 4.2 13 .4 13-6.3v-75h498c35.3 0 64-28.7 64-64V178c0-4.4-3.6-8-8-8z"}}]},name:"enter",theme:"outlined"},gt=mt,Ke=function(r,a){return n.createElement(re.Z,(0,$.Z)((0,$.Z)({},r),{},{ref:a,icon:gt}))};Ke.displayName="EnterOutlined";var Et=n.forwardRef(Ke),je=l(15105),Ct=l(94418),ht=l(96159),St=function(r){var a=r.prefixCls,t=r["aria-label"],o=r.className,u=r.style,O=r.direction,R=r.maxLength,h=r.autoSize,T=h===void 0?!0:h,d=r.value,j=r.onSave,M=r.onCancel,P=r.onEnd,L=r.component,I=r.enterIcon,Y=I===void 0?n.createElement(Et,null):I,F=n.useRef(null),S=n.useRef(!1),V=n.useRef(),U=n.useState(d),Q=(0,p.Z)(U,2),J=Q[0],x=Q[1];n.useEffect(function(){x(d)},[d]),n.useEffect(function(){if(F.current&&F.current.resizableTextArea){var y=F.current.resizableTextArea.textArea;y.focus();var m=y.value.length;y.setSelectionRange(m,m)}},[]);var se=function(m){var b=m.target;x(b.value.replace(/[\n\r]/g,""))},_=function(){S.current=!0},z=function(){S.current=!1},k=function(m){var b=m.keyCode;S.current||(V.current=b)},f=function(){j(J.trim())},ce=function(m){var b=m.keyCode,ue=m.ctrlKey,me=m.altKey,oe=m.metaKey,ee=m.shiftKey;V.current===b&&!S.current&&!ue&&!me&&!oe&&!ee&&(b===je.Z.ENTER?(f(),P==null||P()):b===je.Z.ESC&&M())},q=function(){f()},ae=L?"".concat(a,"-").concat(L):"",N=le()(a,"".concat(a,"-edit-content"),(0,w.Z)({},"".concat(a,"-rtl"),O==="rtl"),o,ae);return n.createElement("div",{className:N,style:u},n.createElement(Ct.Z,{ref:F,maxLength:R,value:J,onChange:se,onKeyDown:k,onKeyUp:ce,onCompositionStart:_,onCompositionEnd:z,onBlur:q,"aria-label":t,rows:1,autoSize:T}),Y!==null?(0,ht.Tm)(Y,{className:"".concat(a,"-edit-content-confirm")}):null)},bt=St;function Me(e,r){return n.useMemo(function(){var a=!!e;return[a,(0,v.Z)((0,v.Z)({},r),a&&(0,X.Z)(e)==="object"?e:null)]},[e])}var xt=function(r,a){var t=n.useRef(!1);n.useEffect(function(){t.current?r():t.current=!0},a)},Ot=xt,Rt=function(e,r){var a={};for(var t in e)Object.prototype.hasOwnProperty.call(e,t)&&r.indexOf(t)<0&&(a[t]=e[t]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var o=0,t=Object.getOwnPropertySymbols(e);o<t.length;o++)r.indexOf(t[o])<0&&Object.prototype.propertyIsEnumerable.call(e,t[o])&&(a[t[o]]=e[t[o]]);return a},Zt=n.forwardRef(function(e,r){var a=e.prefixCls,t=e.component,o=t===void 0?"article":t,u=e.className,O=e.setContentRef,R=e.children,h=e.direction,T=Rt(e,["prefixCls","component","className","setContentRef","children","direction"]),d=n.useContext(ze.E_),j=d.getPrefixCls,M=d.direction,P=h!=null?h:M,L=r;O&&(L=(0,$e.sQ)(r,O));var I=j("typography",a),Y=le()(I,(0,w.Z)({},"".concat(I,"-rtl"),P==="rtl"),u);return n.createElement(o,(0,v.Z)({className:Y,ref:L},T),R)}),Ue=Zt;function Be(e){var r=(0,X.Z)(e);return r==="string"||r==="number"}function wt(e){var r=0;return e.forEach(function(a){Be(a)?r+=String(a).length:r+=1}),r}function We(e,r){for(var a=0,t=[],o=0;o<e.length;o+=1){if(a===r)return t;var u=e[o],O=Be(u),R=O?String(u).length:1,h=a+R;if(h>r){var T=r-a;return t.push(String(u).slice(0,T)),t}t.push(u),a=h}return e}var Pt=0,Se=1,He=2,Le=3,Fe=4,Tt=function(r){var a=r.enabledMeasure,t=r.children,o=r.text,u=r.width,O=r.fontSize,R=r.rows,h=r.onEllipsis,T=n.useState([0,0,0]),d=(0,p.Z)(T,2),j=(0,p.Z)(d[0],3),M=j[0],P=j[1],L=j[2],I=d[1],Y=n.useState(Pt),F=(0,p.Z)(Y,2),S=F[0],V=F[1],U=n.useState(0),Q=(0,p.Z)(U,2),J=Q[0],x=Q[1],se=n.useRef(null),_=n.useRef(null),z=n.useMemo(function(){return(0,Ne.Z)(o)},[o]),k=n.useMemo(function(){return wt(z)},[z]),f=n.useMemo(function(){return!a||S!==Le?t(z,!1):t(We(z,P),P<k)},[a,S,t,z,P,k]);(0,he.Z)(function(){a&&u&&O&&k&&(V(Se),I([0,Math.ceil(k/2),k]))},[a,u,O,o,k,R]),(0,he.Z)(function(){var N;S===Se&&x(((N=se.current)===null||N===void 0?void 0:N.offsetHeight)||0)},[S]),(0,he.Z)(function(){var N,y;if(J){if(S===Se){var m=((N=_.current)===null||N===void 0?void 0:N.offsetHeight)||0,b=R*J;m<=b?(V(Fe),h(!1)):V(He)}else if(S===He)if(M!==L){var ue=((y=_.current)===null||y===void 0?void 0:y.offsetHeight)||0,me=R*J,oe=M,ee=L;M===L-1?ee=M:ue<=me?oe=P:ee=P;var Oe=Math.ceil((oe+ee)/2);I([oe,Oe,ee])}else V(Le),h(!0)}},[S,M,L,R,J]);var ce={width:u,whiteSpace:"normal",margin:0,padding:0},q=function(y,m,b){return n.createElement("span",{"aria-hidden":!0,ref:m,style:(0,v.Z)({position:"fixed",display:"block",left:0,top:0,zIndex:-9999,visibility:"hidden",pointerEvents:"none",fontSize:Math.floor(O/2)*2},b)},y)},ae=function(y,m){var b=We(z,y);return q(t(b,!0),m,ce)};return n.createElement(n.Fragment,null,f,a&&S!==Le&&S!==Fe&&n.createElement(n.Fragment,null,q("lg",se,{wordBreak:"keep-all",whiteSpace:"nowrap"}),S===Se?q(t(z,!1),_,ce):ae(P,_)))},Mt=Tt,Lt=function(r){var a=r.enabledEllipsis,t=r.isEllipsis,o=r.children,u=r.tooltipProps;return!(u==null?void 0:u.title)||!a?o:n.createElement(Te.Z,(0,v.Z)({open:t?void 0:!1},u),o)},It=Lt,Nt=function(e,r){var a={};for(var t in e)Object.prototype.hasOwnProperty.call(e,t)&&r.indexOf(t)<0&&(a[t]=e[t]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var o=0,t=Object.getOwnPropertySymbols(e);o<t.length;o++)r.indexOf(t[o])<0&&Object.prototype.propertyIsEnumerable.call(e,t[o])&&(a[t[o]]=e[t[o]]);return a};function Dt(e,r){var a=e.mark,t=e.code,o=e.underline,u=e.delete,O=e.strong,R=e.keyboard,h=e.italic,T=r;function d(j,M){!j||(T=n.createElement(M,{},T))}return d(O,"strong"),d(o,"u"),d(u,"del"),d(t,"code"),d(a,"mark"),d(R,"kbd"),d(h,"i"),T}function be(e,r,a){return e===!0||e===void 0?r:e||a&&r}function Ve(e){return e===!1?[!1,!1]:Array.isArray(e)?e:[e]}var $t="...",zt=n.forwardRef(function(e,r){var a,t,o,u=e.prefixCls,O=e.className,R=e.style,h=e.type,T=e.disabled,d=e.children,j=e.ellipsis,M=e.editable,P=e.copyable,L=e.component,I=e.title,Y=Nt(e,["prefixCls","className","style","type","disabled","children","ellipsis","editable","copyable","component","title"]),F=n.useContext(ze.E_),S=F.getPrefixCls,V=F.direction,U=(0,yt.E)("Text")[0],Q=n.useRef(null),J=n.useRef(null),x=S("typography",u),se=(0,De.Z)(Y,["mark","code","delete","underline","strong","keyboard","italic"]),_=Me(M),z=(0,p.Z)(_,2),k=z[0],f=z[1],ce=(0,pt.Z)(!1,{value:f.editing}),q=(0,p.Z)(ce,2),ae=q[0],N=q[1],y=f.triggerType,m=y===void 0?["icon"]:y,b=function(i){var c;i&&((c=f.onStart)===null||c===void 0||c.call(f)),N(i)};Ot(function(){var s;ae||(s=J.current)===null||s===void 0||s.focus()},[ae]);var ue=function(i){i==null||i.preventDefault(),b(!0)},me=function(i){var c;(c=f.onChange)===null||c===void 0||c.call(f,i),b(!1)},oe=function(){var i;(i=f.onCancel)===null||i===void 0||i.call(f),b(!1)},ee=Me(P),Oe=(0,p.Z)(ee,2),Ie=Oe[0],ie=Oe[1],Yt=n.useState(!1),Je=(0,p.Z)(Yt,2),Re=Je[0],Ge=Je[1],Qe=n.useRef(),Xe={};ie.format&&(Xe.format=ie.format);var Ye=function(){window.clearTimeout(Qe.current)},_t=function(i){var c;i==null||i.preventDefault(),i==null||i.stopPropagation(),pe()(ie.text||String(d)||"",Xe),Ge(!0),Ye(),Qe.current=window.setTimeout(function(){Ge(!1)},3e3),(c=ie.onCopy)===null||c===void 0||c.call(ie,i)};n.useEffect(function(){return Ye},[]);var qt=n.useState(!1),_e=(0,p.Z)(qt,2),qe=_e[0],en=_e[1],tn=n.useState(!1),et=(0,p.Z)(tn,2),tt=et[0],nn=et[1],rn=n.useState(!1),nt=(0,p.Z)(rn,2),an=nt[0],on=nt[1],ln=n.useState(!1),rt=(0,p.Z)(ln,2),at=rt[0],sn=rt[1],cn=n.useState(!1),ot=(0,p.Z)(cn,2),it=ot[0],un=ot[1],dn=n.useState(!0),lt=(0,p.Z)(dn,2),fn=lt[0],vn=lt[1],pn=Me(j,{expandable:!1}),st=(0,p.Z)(pn,2),te=st[0],E=st[1],B=te&&!an,ct=E.rows,de=ct===void 0?1:ct,Ze=n.useMemo(function(){return!B||E.suffix!==void 0||E.onEllipsis||E.expandable||k||Ie},[B,E,k,Ie]);(0,he.Z)(function(){te&&!Ze&&(en((0,Ae.G)("webkitLineClamp")),nn((0,Ae.G)("textOverflow")))},[Ze,te]);var W=n.useMemo(function(){return Ze?!1:de===1?tt:qe},[Ze,tt,qe]),ut=B&&(W?it:at),yn=B&&de===1&&W,we=B&&de>1&&W,mn=function(i){var c;on(!0),(c=E.onExpand)===null||c===void 0||c.call(E,i)},gn=n.useState(0),dt=(0,p.Z)(gn,2),En=dt[0],Cn=dt[1],hn=n.useState(0),ft=(0,p.Z)(hn,2),Sn=ft[0],bn=ft[1],xn=function(i,c){var Z=i.offsetWidth,A;Cn(Z),bn(parseInt((A=window.getComputedStyle)===null||A===void 0?void 0:A.call(window,c).fontSize,10)||0)},On=function(i){var c;sn(i),at!==i&&((c=E.onEllipsis)===null||c===void 0||c.call(E,i))};n.useEffect(function(){var s=Q.current;if(te&&W&&s){var i=we?s.offsetHeight<s.scrollHeight:s.offsetWidth<s.scrollWidth;it!==i&&un(i)}},[te,W,d,we,fn]),n.useEffect(function(){var s=Q.current;if(!(typeof IntersectionObserver=="undefined"||!s||!W||!B)){var i=new IntersectionObserver(function(){vn(!!s.offsetParent)});return i.observe(s),function(){i.disconnect()}}},[W,B]);var ne={};E.tooltip===!0?ne={title:(a=f.text)!==null&&a!==void 0?a:d}:n.isValidElement(E.tooltip)?ne={title:E.tooltip}:(0,X.Z)(E.tooltip)==="object"?ne=(0,v.Z)({title:(t=f.text)!==null&&t!==void 0?t:d},E.tooltip):ne={title:E.tooltip};var Pe=n.useMemo(function(){var s=function(c){return["string","number"].includes((0,X.Z)(c))};if(!(!te||W)){if(s(f.text))return f.text;if(s(d))return d;if(s(I))return I;if(s(ne.title))return ne.title}},[te,W,I,ne.title,ut]);if(ae)return n.createElement(bt,{value:(o=f.text)!==null&&o!==void 0?o:typeof d=="string"?d:"",onSave:me,onCancel:oe,onEnd:f.onEnd,prefixCls:x,className:O,style:R,direction:V,component:L,maxLength:f.maxLength,autoSize:f.autoSize,enterIcon:f.enterIcon});var Rn=function(){var i=E.expandable,c=E.symbol;if(!i)return null;var Z;return c?Z=c:Z=U.expand,n.createElement("a",{key:"expand",className:"".concat(x,"-expand"),onClick:mn,"aria-label":U.expand},Z)},Zn=function(){if(!!k){var i=f.icon,c=f.tooltip,Z=(0,Ne.Z)(c)[0]||U.edit,A=typeof Z=="string"?Z:"";return m.includes("icon")?n.createElement(Te.Z,{key:"edit",title:c===!1?"":Z},n.createElement(ke.Z,{ref:J,className:"".concat(x,"-edit"),onClick:ue,"aria-label":A},i||n.createElement(g,{role:"button"}))):null}},wn=function(){if(!!Ie){var i=ie.tooltips,c=ie.icon,Z=Ve(i),A=Ve(c),ge=Re?be(Z[1],U.copied):be(Z[0],U.copy),Mn=Re?U.copied:U.copy,Ln=typeof ge=="string"?ge:Mn;return n.createElement(Te.Z,{key:"copy",title:ge},n.createElement(ke.Z,{className:le()("".concat(x,"-copy"),Re&&"".concat(x,"-copy-success")),onClick:_t,"aria-label":Ln},Re?be(A[1],n.createElement(H.Z,null),!0):be(A[0],n.createElement(C.Z,null),!0)))}},Pn=function(i){return[i&&Rn(),Zn(),wn()]},Tn=function(i){return[i&&n.createElement("span",{"aria-hidden":!0,key:"ellipsis"},$t),E.suffix,Pn(i)]};return n.createElement(vt.Z,{onResize:xn,disabled:!B||W},function(s){var i;return n.createElement(It,{tooltipProps:ne,enabledEllipsis:B,isEllipsis:ut},n.createElement(Ue,(0,v.Z)({className:le()((i={},(0,w.Z)(i,"".concat(x,"-").concat(h),h),(0,w.Z)(i,"".concat(x,"-disabled"),T),(0,w.Z)(i,"".concat(x,"-ellipsis"),te),(0,w.Z)(i,"".concat(x,"-single-line"),B&&de===1),(0,w.Z)(i,"".concat(x,"-ellipsis-single-line"),yn),(0,w.Z)(i,"".concat(x,"-ellipsis-multiple-line"),we),i),O),prefixCls:u,style:(0,v.Z)((0,v.Z)({},R),{WebkitLineClamp:we?de:void 0}),component:L,ref:(0,$e.sQ)(s,Q,r),direction:V,onClick:m.includes("text")?ue:void 0,"aria-label":Pe==null?void 0:Pe.toString(),title:I},se),n.createElement(Mt,{enabledMeasure:B&&!W,text:d,rows:de,width:En,fontSize:Sn,onEllipsis:On},function(c,Z){var A=c;c.length&&Z&&Pe&&(A=n.createElement("span",{key:"show-content","aria-hidden":!0},A));var ge=Dt(e,n.createElement(n.Fragment,null,A,Tn(Z)));return ge})))})}),xe=zt,kt=function(e,r){var a={};for(var t in e)Object.prototype.hasOwnProperty.call(e,t)&&r.indexOf(t)<0&&(a[t]=e[t]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var o=0,t=Object.getOwnPropertySymbols(e);o<t.length;o++)r.indexOf(t[o])<0&&Object.prototype.propertyIsEnumerable.call(e,t[o])&&(a[t[o]]=e[t[o]]);return a},At=n.forwardRef(function(e,r){var a=e.ellipsis,t=e.rel,o=kt(e,["ellipsis","rel"]),u=(0,v.Z)((0,v.Z)({},o),{rel:t===void 0&&o.target==="_blank"?"noopener noreferrer":t});return delete u.navigate,n.createElement(xe,(0,v.Z)({},u,{ref:r,ellipsis:!!a,component:"a"}))}),Kt=At,jt=n.forwardRef(function(e,r){return n.createElement(xe,(0,v.Z)({ref:r},e,{component:"div"}))}),Ut=jt,Bt=function(e,r){var a={};for(var t in e)Object.prototype.hasOwnProperty.call(e,t)&&r.indexOf(t)<0&&(a[t]=e[t]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var o=0,t=Object.getOwnPropertySymbols(e);o<t.length;o++)r.indexOf(t[o])<0&&Object.prototype.propertyIsEnumerable.call(e,t[o])&&(a[t[o]]=e[t[o]]);return a},Wt=function(r,a){var t=r.ellipsis,o=Bt(r,["ellipsis"]),u=n.useMemo(function(){return t&&(0,X.Z)(t)==="object"?(0,De.Z)(t,["expandable","rows"]):t},[t]);return n.createElement(xe,(0,v.Z)({ref:a},o,{ellipsis:u,component:"span"}))},Ht=n.forwardRef(Wt),Ft=l(93355),Vt=function(e,r){var a={};for(var t in e)Object.prototype.hasOwnProperty.call(e,t)&&r.indexOf(t)<0&&(a[t]=e[t]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var o=0,t=Object.getOwnPropertySymbols(e);o<t.length;o++)r.indexOf(t[o])<0&&Object.prototype.propertyIsEnumerable.call(e,t[o])&&(a[t[o]]=e[t[o]]);return a},Jt=(0,Ft.a)(1,2,3,4,5),Gt=n.forwardRef(function(e,r){var a=e.level,t=a===void 0?1:a,o=Vt(e,["level"]),u;return Jt.includes(t)?u="h".concat(t):u="h1",n.createElement(xe,(0,v.Z)({ref:r},o,{component:u}))}),Qt=Gt,ye=Ue;ye.Text=Ht,ye.Link=Kt,ye.Title=Qt,ye.Paragraph=Ut;var Xt=ye},402:function(fe,D,l){"use strict";var v=l(38663),n=l.n(v),w=l(47828),X=l.n(w),p=l(47673),H=l(22385)},20640:function(fe,D,l){"use strict";var v=l(11742),n={"text/plain":"Text","text/html":"Url",default:"Text"},w="Copy to clipboard: #{key}, Enter";function X(H){var C=(/mac os x/i.test(navigator.userAgent)?"\u2318":"Ctrl")+"+C";return H.replace(/#{\s*key\s*}/g,C)}function p(H,C){var $,Ee,Ce,re,G,g,ve=!1;C||(C={}),$=C.debug||!1;try{Ce=v(),re=document.createRange(),G=document.getSelection(),g=document.createElement("span"),g.textContent=H,g.ariaHidden="true",g.style.all="unset",g.style.position="fixed",g.style.top=0,g.style.clip="rect(0, 0, 0, 0)",g.style.whiteSpace="pre",g.style.webkitUserSelect="text",g.style.MozUserSelect="text",g.style.msUserSelect="text",g.style.userSelect="text",g.addEventListener("copy",function(K){if(K.stopPropagation(),C.format)if(K.preventDefault(),typeof K.clipboardData=="undefined"){$&&console.warn("unable to use e.clipboardData"),$&&console.warn("trying IE specific stuff"),window.clipboardData.clearData();var pe=n[C.format]||n.default;window.clipboardData.setData(pe,H)}else K.clipboardData.clearData(),K.clipboardData.setData(C.format,H);C.onCopy&&(K.preventDefault(),C.onCopy(K.clipboardData))}),document.body.appendChild(g),re.selectNodeContents(g),G.addRange(re);var le=document.execCommand("copy");if(!le)throw new Error("copy command was unsuccessful");ve=!0}catch(K){$&&console.error("unable to copy using execCommand: ",K),$&&console.warn("trying IE specific stuff");try{window.clipboardData.setData(C.format||"text",H),C.onCopy&&C.onCopy(window.clipboardData),ve=!0}catch(pe){$&&console.error("unable to copy using clipboardData: ",pe),$&&console.error("falling back to prompt"),Ee=X("message"in C?C.message:w),window.prompt(Ee,H)}}finally{G&&(typeof G.removeRange=="function"?G.removeRange(re):G.removeAllRanges()),g&&document.body.removeChild(g),Ce()}return ve}fe.exports=p},11742:function(fe){fe.exports=function(){var D=document.getSelection();if(!D.rangeCount)return function(){};for(var l=document.activeElement,v=[],n=0;n<D.rangeCount;n++)v.push(D.getRangeAt(n));switch(l.tagName.toUpperCase()){case"INPUT":case"TEXTAREA":l.blur();break;default:l=null;break}return D.removeAllRanges(),function(){D.type==="Caret"&&D.removeAllRanges(),D.rangeCount||v.forEach(function(w){D.addRange(w)}),l&&l.focus()}}}}]);