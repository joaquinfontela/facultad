import React from 'react'
import "./UpdateWindow.css"
import * as data from '../../../data/data.json'
import SubjectCheckbox from "./SubjectCheckbox/SubjectCheckbox"
import { JsxEmit } from 'typescript';

interface UpdateWindowState {
    passedSubjectsCodes: string[],
    failedSubjectsCodes: string[]
}

export class UpdateWindow extends React.Component<{}, UpdateWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            passedSubjectsCodes: [],
            failedSubjectsCodes: []
        }
        this.handlePassedClick = this.handlePassedClick.bind(this);
        this.handleFailedClick = this.handleFailedClick.bind(this);
    }

    handlePassedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!passed.includes(subjectCode)) {
            passed.push(subjectCode);
            if (failed.includes(subjectCode)) {
                failed.splice(failed.indexOf(subjectCode), 1);
            }
        } else {
            passed.splice(passed.indexOf(subjectCode), 1);
        }

        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    handleFailedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!failed.includes(subjectCode)) {
            failed.push(subjectCode);
            if (passed.includes(subjectCode)) {
                passed.splice(passed.indexOf(subjectCode), 1);
            }
        } else {
            failed.splice(failed.indexOf(subjectCode), 1);
        }

        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    render(): JSX.Element {
        const subjectCodes: string[] = data.data.subjectCodes.sistemas;

        subjectCodes.sort(function (a: string, b: string) {
            var keyA: number = Number(a);
            var keyB: number = Number(b);
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjectCheckboxes: JSX.Element[] = subjectCodes.map(s => {
            return (
                <SubjectCheckbox code={s}
                    passed={this.state.passedSubjectsCodes.includes(s)}
                    failed={this.state.failedSubjectsCodes.includes(s)}
                    handlePassedClick={this.handlePassedClick}
                    handleFailedClick={this.handleFailedClick} />
            );
        })

        let subjectCheckboxesList1;
        let subjectCheckboxesList2;
        let subjectCheckboxesList3;
        let subjectCheckboxesList4;

        switch (subjectCheckboxes.length % 4) {


            case 0:
                subjectCheckboxesList1 = subjectCheckboxes.slice(0, (subjectCheckboxes.length) / 4);
                subjectCheckboxesList2 = subjectCheckboxes.slice((subjectCheckboxes.length) / 4, (subjectCheckboxes.length) / 2);
                subjectCheckboxesList3 = subjectCheckboxes.slice((subjectCheckboxes.length) / 2, 3 * (subjectCheckboxes.length) / 4);
                subjectCheckboxesList4 = subjectCheckboxes.slice(3 * (subjectCheckboxes.length) / 4);
                break;
            case 1:
                subjectCheckboxesList1 = subjectCheckboxes.slice(0, (subjectCheckboxes.length) / 4 + 0.75);
                subjectCheckboxesList2 = subjectCheckboxes.slice((subjectCheckboxes.length) / 4 + 0.75, (subjectCheckboxes.length) / 2 + 0.5);
                subjectCheckboxesList3 = subjectCheckboxes.slice((subjectCheckboxes.length) / 2 + 0.5, 3 * (subjectCheckboxes.length) / 4 + 0.25);
                subjectCheckboxesList4 = subjectCheckboxes.slice(3 * (subjectCheckboxes.length) / 4 + 0.25);
                break;
            case 2:
                subjectCheckboxesList1 = subjectCheckboxes.slice(0, (subjectCheckboxes.length) / 4 + 0.5);
                subjectCheckboxesList2 = subjectCheckboxes.slice((subjectCheckboxes.length) / 4 + 0.5, (subjectCheckboxes.length) / 2 + 1);
                subjectCheckboxesList3 = subjectCheckboxes.slice((subjectCheckboxes.length) / 2 + 1, 3 * (subjectCheckboxes.length) / 4 + 0.5);
                subjectCheckboxesList4 = subjectCheckboxes.slice(3 * (subjectCheckboxes.length) / 4 + 0.5);
                break;
            default:
                subjectCheckboxesList1 = subjectCheckboxes.slice(0, (subjectCheckboxes.length) / 4 + 0.25);
                subjectCheckboxesList2 = subjectCheckboxes.slice((subjectCheckboxes.length) / 4 + 0.25, (subjectCheckboxes.length) / 2 + 0.5);
                subjectCheckboxesList3 = subjectCheckboxes.slice((subjectCheckboxes.length) / 2 + 0.5, 3 * (subjectCheckboxes.length) / 4 + 0.75);
                subjectCheckboxesList4 = subjectCheckboxes.slice(3 * (subjectCheckboxes.length) / 4 + 0.75);
                break;
        }

        return (
            <div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList1}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList2}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList3}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList4}</ul>
                </div>
            </div >
        );
    }
}
