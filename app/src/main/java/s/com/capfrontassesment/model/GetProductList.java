package s.com.capfrontassesment.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductList {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("content")
    @Expose
    private List<Content> content = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}