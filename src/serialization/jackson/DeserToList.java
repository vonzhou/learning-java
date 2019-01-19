package serialization.jackson;

import java.util.List;

/**
 * @author vonzhou
 * @date 2018/12/3
 */
public class DeserToList {
    public static void main(String[] args) {
        String s = "[{\"id\":5,\"scope\":1,\"logic\":\"20 && 21 || 22 || 23\",\"express\":{\"express\":\"值相等(roleName,\\\"test\\\") && operator == 1 || 值不相等(pathDoubtful,\\\"1\\\") || inBean.stat0(appId, 13, mac, 1800000) == 2\",\"vars\":[\"roleName\",\"pathDoubtful\",\"operator\",\"mac\"]},\"internalTag\":1,\"externalTag\":1}]";
        List<Foo> list = JacksonUtils.fromJson(s, List.class);
        System.out.println(list);
        for(Foo f : list){
            System.out.println(f.getId());
        }

    }


    static class Foo{
        private Long id;

        private Integer scope;
        private String logic;

        private Long internalTag;

        private Long externalTag;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getScope() {
            return scope;
        }

        public void setScope(Integer scope) {
            this.scope = scope;
        }

        public String getLogic() {
            return logic;
        }

        public void setLogic(String logic) {
            this.logic = logic;
        }

        public Long getInternalTag() {
            return internalTag;
        }

        public void setInternalTag(Long internalTag) {
            this.internalTag = internalTag;
        }

        public Long getExternalTag() {
            return externalTag;
        }

        public void setExternalTag(Long externalTag) {
            this.externalTag = externalTag;
        }
    }
}
