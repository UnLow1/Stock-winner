import {Component, Input, OnInit} from '@angular/core';
import * as Chart from 'chart.js';
import {IChart} from "../../model/chart";

@Component({
  selector: 'app-chart-form',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.scss']
})

export class ChartComponent implements OnInit {

  @Input() charts: IChart[];

  canvas: any;
  ctx: any;

  ngOnInit() {
    this.canvas = document.getElementById('myChart');
    this.ctx = this.canvas.getContext('2d');
    let myChart = new Chart(this.ctx, {
      type: 'line',
      data: {
        labels: this.charts.map(c => c.date),
        datasets: [{
          label: 'Company shares chart',
          data: this.charts.map(c => c.close),
          backgroundColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        responsive: false
      }
    });
  }

  rebuild() {
    this.ngOnInit();
  }
}
