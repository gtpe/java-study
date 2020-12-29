package w7.modifier.test_protected_2;

import test_modifier.test_protected.A_Class;

/**
 * 접근제한자 protected 테스트.
 */
public class C_Class extends A_Class {

    public static void main(String[] args) {
        /**
         * A_Class의 a() 메소드의 접근제한자가 protected이기 때문에
         * 패키지가 다른 이곳 C_Class에서 상속을 하지 않고 사용하면 컴파일 에러가 발생한다.
         */
        /*A_Class a_class = new A_Class();
        a_class.a();*/
        /**
         * A_Class를 상속 받은 후 a()를 호출하면 정상적으로 실행이 된다.
         */
        C_Class c_class = new C_Class();
        c_class.a();
    }

}
