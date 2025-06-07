package viniciushoffmanndev.desafio_itau_backend.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticResponse {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public StatisticResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }

}
