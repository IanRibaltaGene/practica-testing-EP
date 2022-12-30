package data;

import exception.NullPathException;

final public class DocPath {

    private final String docPath;

    public DocPath(String docPath) throws NullPathException {
        if(docPath == null){
            throw new NullPathException("Document path parameter cannot be null");
        }
        this.docPath = docPath;
    }

    public String getDocPath() {
        return docPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocPath docPath1 = (DocPath) o;

        return getDocPath().equals(docPath1.getDocPath());
    }

    @Override
    public int hashCode() {
        return getDocPath().hashCode();
    }

    @Override
    public String toString() {
        return "DocPath{" +
                "document path='" + docPath + '\'' +
                '}';
    }
}
