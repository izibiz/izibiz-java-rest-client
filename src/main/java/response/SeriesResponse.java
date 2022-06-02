package response;

public class SeriesResponse {
    public DataSeries[] dataSeries;

    public DataSeries[] getDatas() {
        return dataSeries;
    }

    public void setDatas(DataSeries[] datas) {
        this.dataSeries = datas;
    }

    public String error;

    public String warning;
}
